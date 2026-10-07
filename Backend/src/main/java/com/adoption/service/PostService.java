package com.adoption.service;

import com.adoption.dto.PostRequest;
import com.adoption.entity.Post;
import com.adoption.entity.User;
import com.adoption.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final AdoptionRequestRepository adoptionRequestRepository;
    private final DonationRepository donationRepository;
    private final ReportRepository reportRepository;

    // post request c'est le DTO et le current user requpere de token
    // creation d'une post
    public Post createPost(PostRequest request , User currentUser){
        // Vérifier qu'au moins un des deux est true
        if(!request.getIsAdoption() && !request.getIsDonation()){
            throw new RuntimeException("Le post doit etre une adoption ou une donation  ou les deux ");
        }
        // Vérifier si isDonation = true → cardNumber obligatoire
        if (request.getIsDonation()) {
            if (request.getCardNumber()==null || request.getCardNumber().isBlank()) {
                throw new RuntimeException("le numero de carte est obligatoire pour une donation !");
            }
        }

        Post post=Post.builder().user(currentUser).title(request.getTitle()).description(request.getDescription()).image(request.getImage()).category(request.getCategory()).city(Post.City.valueOf(request.getCity()))
                .localisationDetail(request.getLocalisation_detail()).isDonation(request.getIsDonation()).isAdoption(request.getIsAdoption()).cardNumber(request.getCardNumber()).cardHolderName(request.getCardHolderName())
                .status(Post.Status.available).build();
        return postRepository.save(post);
    }

    // voir tous les post dispo
    public List<Post> getAllPosts(){
        return postRepository.findByStatus(Post.Status.available);
    }

    // voir un post par id
    public  Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow(()->new RuntimeException("post non trouvée"));
    }
    // voir les posts d'un utlisateur
    public List<Post> getMyPosts(User currentUser){
        return  postRepository.findByUserId(currentUser.getId());
    }
    // voir les postes d'adoptation seulment
    public List<Post> getAdoptionPosts(){
        return postRepository.findByIsAdoptionTrue();
    }
    // voir les postes de donnation seulment
    public List<Post> getDonationPosts(){
        return postRepository.findByIsDonationIsTrue();
    }
    //Modifier un post
    public Post updatePost( Long id , PostRequest request, User currentUser ){
        Post post =postRepository.findById(id).orElseThrow(()->new RuntimeException("Post non trouvée"));
        //verifier que c'est le priporitaire de la poste
        if(!post.getUser().getId().equals(currentUser.getId())){
            throw new RuntimeException("vous n'etes pas autorisée a modifier ce post !");
        }
        //verifier q'au moins un des deux est true
        if (!request.getIsAdoption()&& !request.getIsDonation()){
            throw new RuntimeException("le post soit au moins une adoption ou une donation!");
        }
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setImage(request.getImage());
        post.setCategory(request.getCategory());
        post.setCity(Post.City.valueOf(request.getCity()));
        post.setLocalisationDetail(request.getLocalisation_detail());
        post.setIsAdoption(request.getIsAdoption());
        post.setIsDonation(request.getIsDonation());
        post.setCardNumber(request.getCardNumber());
        post.setCardHolderName(request.getCardHolderName());

        return postRepository.save(post);
    }
    //fermer une post par le propriétaire
    public  Post closePost(Long id , User currentUser){
        Post post =postRepository.findById(id).orElseThrow(()-> new RuntimeException("post non touvée! "));
        // verifier s'il est le prioritaire de poste
        if(!post.getUser().getId().equals(currentUser.getId())){
            throw new RuntimeException("vous na pas le droit de supprimer cette poste !");
        }
        if (post.getStatus() == Post.Status.adopted){
            throw new RuntimeException("ce poste est deja adoptée !");
        }

        post.setStatus(Post.Status.closed);
        return postRepository.save(post);
    }

    // supprimer un post (pr l'admin)
    public  void removePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->new RuntimeException("post non trouvée"));
        post.setStatus(Post.Status.removed);
        postRepository.save(post);
    }

    // rechercher par categorie
    public List<Post> getPostsByCategory(String category){
        return postRepository.findByCategory(category);
    }

    // recherche par ville
    public List<Post> getPostsByCity(String city){
        return postRepository.findByCity(Post.City.valueOf(city));
    }

    // recherche avancée
    public List<Post> searchPosts(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return postRepository.findAll();
        }
        return postRepository.searchByKeyword(keyword.trim());
    }
    @Transactional
    public void deletePost(Long id, User currentUser) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post non trouvé"));

        if (!post.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("Vous n'êtes pas autorisé à supprimer ce post");
        }
        commentRepository.deleteByPostId(id);
        adoptionRequestRepository.deleteByPostId(id);
        donationRepository.deleteByPostId(id);
        reportRepository.deleteByPostId(id);

        postRepository.delete(post);
    }
}