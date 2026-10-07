package com.adoption.service;

import com.adoption.dto.AdoptionRequestRequest;
import com.adoption.entity.AdoptionRequest;
import com.adoption.entity.Post;
import com.adoption.entity.User;
import com.adoption.repository.AdoptionRequestRepository;
import com.adoption.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionRequestService {
private final AdoptionRequestRepository adoptionRequestRepository;
private final PostRepository postRepository;
// creer une demande d'adoptation
    public AdoptionRequest createRequest(AdoptionRequestRequest request, User currentUser){

        //recuperer la poste
        Post post= postRepository.findById(request.getPostId()).orElseThrow(()->new RuntimeException("post non trouvé !"));
        //verifier que le post est dipo
        if(post.getStatus() != Post.Status.available){
            throw new RuntimeException("la post n'est plus disponible !");
        }
        // verifier que la post est une adoptation
        if(!post.getIsAdoption()){
            throw new RuntimeException("ce poste est n'est pas une adoption !");
        }
        //verifier que le propritaire ne demande pas son post
        if(post.getUser().getId().equals(currentUser.getId())){
            throw new RuntimeException("Vous ne pouvez pas adpater votre animal !");
        }
        // verifier si l'utlisateur a deja demandé ce post
        if(adoptionRequestRepository.existsByPostIdAndRequesterId(post.getId(),currentUser.getId())){
            throw new RuntimeException("vous avez deja demandé ce post !");
        }
        // creer la demande
        AdoptionRequest adoptionRequest=AdoptionRequest.builder().post(post).requester(currentUser).owner(post.getUser()).status(AdoptionRequest.Status.pending)
                .message(request.getMessage()).hasExperience(request.getHasExperience()).housingType(AdoptionRequest.HousingType.valueOf(request.getHousingType()))
                .hasGarden(request.getHasGarden()).hasChildren(request.getHasChildren()).phoneNumber(request.getPhoneNumber()).build();
        return adoptionRequestRepository.save(adoptionRequest);
    }

    // voir les demandes recus (pour le propritaire)
    public List<AdoptionRequest> getRecievedRequests(User currentUser){
        return adoptionRequestRepository.findByOwnerId(currentUser.getId());
    }
    // voir les demandes envoyées (demandeur)
    public List<AdoptionRequest> getSentRequest(User currentUser){
        return adoptionRequestRepository.findByRequesterId(currentUser.getId());
    }
    // voir les demandes d'un post
    public List<AdoptionRequest> getRequestesByPost(Long postId, User currentUser){
        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post non trouvé"));
        // verifier que c'est le propritaire
        if(!post.getUser().getId().equals(currentUser.getId())){
            throw  new RuntimeException("vous n'ete pas autorisées de voir les requests pour ce post");
        }
        return adoptionRequestRepository.findByPostId(postId);
    }
    //Accepter une demande
    public  AdoptionRequest accepteRequest(Long requestId, User currentUser){
        AdoptionRequest adoptionRequest= adoptionRequestRepository.findById(requestId).orElseThrow(()->new RuntimeException("demande non trouvée"));
        // verifier que c'est le proprtaire
        if(!adoptionRequest.getOwner().getId().equals(currentUser.getId())){
            throw new RuntimeException("vous n'etes pas autorisées !");
        }
        // verifier que la demande en attente
        if(adoptionRequest.getStatus()!= AdoptionRequest.Status.pending){
            throw new RuntimeException("cette demande n'est plus en attente");
        }
        //accepter la demande
        adoptionRequest.setStatus(AdoptionRequest.Status.accepted);
        adoptionRequestRepository.save(adoptionRequest);
        // rejecter tous les autres demande pour ce post
        List<AdoptionRequest> otherRequests = adoptionRequestRepository
                .findByPostIdAndStatus(
                        adoptionRequest.getPost().getId(),
                        AdoptionRequest.Status.pending
                );
        for(AdoptionRequest other :otherRequests){
            other.setStatus(AdoptionRequest.Status.rejected);
            adoptionRequestRepository.save(other);
        }
         // changer le status de post en adopted
        Post post =adoptionRequest.getPost();
        post.setStatus(Post.Status.adopted);
        postRepository.save(post);
        return adoptionRequest;
    }
    //refuser une demande
    public AdoptionRequest rejectRequest(Long requestId, User currentUser){
        AdoptionRequest adoptionRequest=adoptionRequestRepository.findById(requestId).orElseThrow(()->new RuntimeException("demande non trouvée"));
        //verifier que c'est le propritaire
        if(!adoptionRequest.getOwner().getId().equals(currentUser.getId())){
            throw new RuntimeException("vous n'etes pas autorisées !");
        }
        //verifier que la demande est encore pending
        if(adoptionRequest.getStatus()!= AdoptionRequest.Status.pending){
            throw new RuntimeException("cette demande n'est plus en attente");
        }
        adoptionRequest.setStatus(AdoptionRequest.Status.rejected);
        return adoptionRequestRepository.save(adoptionRequest);
    }
    // Annuler une demande (par le demandeur)
    public AdoptionRequest cancelRequest(Long requestId, User currentUser){
        AdoptionRequest adoptionRequest = adoptionRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));

        // Vérifier que c'est bien le demandeur
        if (!adoptionRequest.getRequester().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Vous n'êtes pas autorisé !");
        }

        // Vérifier que la demande est encore pending
        if (adoptionRequest.getStatus() != AdoptionRequest.Status.pending) {
            throw new RuntimeException("Cette demande ne peut plus être annulée !");
        }

        adoptionRequest.setStatus(AdoptionRequest.Status.cancelled);
        return adoptionRequestRepository.save(adoptionRequest);
    }

}
