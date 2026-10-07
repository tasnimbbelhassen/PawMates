package com.adoption.service;

import com.adoption.dto.DonationRequest;
import com.adoption.entity.Donation;
import com.adoption.entity.Post;
import com.adoption.entity.User;
import com.adoption.repository.DonationRepository;
import com.adoption.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;
    private final PostRepository postRepository;

    // Faire un don
    public Donation createDonation(DonationRequest request, User currentUser) {

        // Récupérer le post
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post non trouvé"));

        // Vérifier que le post accepte les donations
        if (!post.getIsDonation()) {
            throw new RuntimeException("Ce post n'accepte pas les donations !");
        }

        // Vérifier que le post est disponible
        if (post.getStatus() != Post.Status.available) {
            throw new RuntimeException("Ce post n'est plus disponible !");
        }

        // Vérifier que le propriétaire ne fait pas un don à lui même
        if (post.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Vous ne pouvez pas faire un don à vous même !");
        }

        // Prendre les 4 derniers chiffres de la carte
        String lastFour = request.getCardNumber().substring(12);

        // Créer la donation
        Donation donation = Donation.builder()
                .post(post)
                .user(currentUser)
                .owner(post.getUser())
                .donorCardLastFour(lastFour)
                .donorCardHolderName(request.getCardHolderName())
                .amount(request.getAmount())
                .transactionId(UUID.randomUUID().toString())
                .build();

        return donationRepository.save(donation);
    }

    // Voir les donations faites par l'utilisateur
    public List<Donation> getMyDonations(User currentUser) {
        return donationRepository.findByUserId(currentUser.getId());
    }

    // Voir les donations reçues par le propriétaire
    public List<Donation> getReceivedDonations(User currentUser) {
        return donationRepository.findByOwnerId(currentUser.getId());
    }

    // Voir les donations d'un post
    public List<Donation> getDonationsByPost(Long postId, User currentUser) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post non trouvé"));

        // Vérifier que c'est bien le propriétaire
        if (!post.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Vous n'êtes pas autorisé !");
        }

        return donationRepository.findByPostId(postId);
    }

    // Voir le total des donations d'un post
    public BigDecimal getTotalDonationsByPost(Long postId, User currentUser) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post non trouvé"));

        // Vérifier que c'est bien le propriétaire
        if (!post.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Vous n'êtes pas autorisé !");
        }

        BigDecimal total = donationRepository.sumAmountByPostId(postId);

        // Si aucune donation → retourner 0
        return total != null ? total : BigDecimal.ZERO;
    }

    // Nombre de donations d'un post
    public int countDonationsByPost(Long postId) {
        return donationRepository.countByPostId(postId);
    }
}