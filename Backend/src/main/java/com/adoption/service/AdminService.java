package com.adoption.service;

import com.adoption.entity.Post;
import com.adoption.entity.Report;
import com.adoption.entity.User;
import com.adoption.repository.AdoptionRequestRepository;
import com.adoption.repository.DonationRepository;
import com.adoption.repository.PostRepository;
import com.adoption.repository.CommentRepository;
import com.adoption.repository.ReportRepository;
import com.adoption.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ReportRepository reportRepository;
    private final DonationRepository donationRepository;
    private final AdoptionRequestRepository adoptionRequestRepository;
    private final CommentRepository commentRepository;

    // ************************
    // GESTION DES UTILISATEURS


    // Voir tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Promouvoir un user en admin
    public User promoteToAdmin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (user.getRole() == User.Role.admin) {
            throw new RuntimeException("Cet utilisateur est déjà admin !");
        }

        user.setRole(User.Role.admin);
        return userRepository.save(user);
    }

    // Rétrograder un admin en user
    public User demoteToUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (user.getRole() == User.Role.user) {
            throw new RuntimeException("Cet utilisateur est déjà un user !");
        }

        user.setRole(User.Role.user);
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Post> userPosts = postRepository.findByUserId(userId);
        for (Post post : userPosts) {
            donationRepository.deleteByPostId(post.getId());
        }

        // Supprimer les donations faites par l'utilisateur directement
        donationRepository.deleteByUserId(userId);

        commentRepository.deleteByPostUserId(userId);
        reportRepository.deleteByPostUserId(userId);
        adoptionRequestRepository.deleteByPostUserId(userId);
        adoptionRequestRepository.deleteByRequesterId(userId); // en tant que demandeur
        adoptionRequestRepository.deleteByOwnerId(userId);     // en tant que propriétaire
        postRepository.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }
    // ******************
    // GESTION DES POSTS


    // Voir tous les posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Voir les posts par status
    public List<Post> getPostsByStatus(Post.Status status) {
        return postRepository.findByStatus(status);
    }

    // ***************
    // STATISTIQUES
    public Map<String, Long> getUserStats(Long userId) {
        Map<String, Long> stats = new HashMap<>();
        stats.put("posts_count", postRepository.countByUserId(userId));
        stats.put("adoption_requests_count", adoptionRequestRepository.countByRequesterId(userId));
        stats.put("donations_count", donationRepository.countByUserId(userId));
        return stats;
    }
    public Map<String, Object> getStatistics() {
        Map<String, Object> stats = new HashMap<>();

        // Counts de base
        stats.put("totalUsers", userRepository.count());
        stats.put("totalPosts", postRepository.count());
        stats.put("totalReports", reportRepository.count());
        stats.put("totalDonations", donationRepository.count());
        stats.put("totalAdoptionRequests", adoptionRequestRepository.count());
        stats.put("pendingReports", reportRepository.countByStatus(Report.Status.pending));

        // Posts par statut
        Map<String, Long> postsByStatus = new HashMap<>();
        postsByStatus.put("available", postRepository.countByStatus(Post.Status.available));
        postsByStatus.put("adopted", postRepository.countByStatus(Post.Status.adopted));
        postsByStatus.put("closed", postRepository.countByStatus(Post.Status.closed));
        postsByStatus.put("removed", postRepository.countByStatus(Post.Status.removed));
        stats.put("postsByStatus", postsByStatus);

        // 5 derniers posts
        stats.put("recentPosts", postRepository.findTop5ByOrderByCreatedAtDesc());

        // 5 derniers users
        stats.put("recentUsers", userRepository.findTop5ByOrderByCreatedAtDesc());

        return stats;
    }
}