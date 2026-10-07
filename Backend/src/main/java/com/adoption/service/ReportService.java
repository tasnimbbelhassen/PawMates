package com.adoption.service;

import com.adoption.dto.ReportRequest;
import com.adoption.entity.Post;
import com.adoption.entity.Report;
import com.adoption.entity.User;
import com.adoption.repository.PostRepository;
import com.adoption.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final PostRepository postRepository;

    // Créer un signalement
    public Report createReport(ReportRequest request, User currentUser) {

        // Récupérer le post
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post non trouvé"));

        // Vérifier que le post est disponible
        if (post.getStatus() == Post.Status.removed) {
            throw new RuntimeException("Ce post est déjà supprimé !");
        }

        // Vérifier que le propriétaire ne signale pas son propre post
        if (post.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException(
                    "Vous ne pouvez pas signaler votre propre post !");
        }

        // Vérifier si l'utilisateur a déjà signalé ce post
        if (reportRepository.existsByPostIdAndReporterId(
                post.getId(), currentUser.getId())) {
            throw new RuntimeException("Vous avez déjà signalé ce post !");
        }

        // Créer le signalement
        Report report = Report.builder()
                .post(post)
                .reporter(currentUser)
                .reason(request.getReason())
                .status(Report.Status.pending)
                .build();

        return reportRepository.save(report);
    }

    // Voir tous les signalements — admin seulement
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // Voir les signalements par status — admin seulement
    public List<Report> getReportsByStatus(Report.Status status) {
        return reportRepository.findByStatus(status);
    }

    // Voir les signalements d'un post — admin seulement
    public List<Report> getReportsByPost(Long postId) {
        return reportRepository.findByPostId(postId);
    }

    // Mettre un signalement en cours de traitement — admin
    public Report reviewReport(Long reportId) {

        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Signalement non trouvé"));

        // Vérifier que le signalement est pending
        if (report.getStatus() != Report.Status.pending) {
            throw new RuntimeException("Ce signalement est déjà traité !");
        }

        report.setStatus(Report.Status.under_review);
        return reportRepository.save(report);
    }

    // Valider le signalement et supprimer le post — admin
    public Report resolveReport(Long reportId) {

        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Signalement non trouvé"));

        // Changer le status du signalement
        report.setStatus(Report.Status.resolved);
        reportRepository.save(report);

        // Supprimer le post (soft delete)
        Post post = report.getPost();
        post.setStatus(Post.Status.removed);
        postRepository.save(post);

        // Résoudre tous les autres signalements du même post
        List<Report> otherReports = reportRepository
                .findByPostId(post.getId());

        for (Report other : otherReports) {
            if (other.getStatus() == Report.Status.pending ||
                    other.getStatus() == Report.Status.under_review) {
                other.setStatus(Report.Status.resolved);
            }
        }
        reportRepository.saveAll(otherReports);

        return report;
    }

    // Ignorer le signalement — admin
    public Report dismissReport(Long reportId) {

        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Signalement non trouvé"));

        // Vérifier que le signalement n'est pas déjà traité
        if (report.getStatus() == Report.Status.resolved ||
                report.getStatus() == Report.Status.dismissed) {
            throw new RuntimeException("Ce signalement est déjà traité !");
        }

        report.setStatus(Report.Status.dismissed);
        return reportRepository.save(report);
    }

    // Nombre de signalements d'un post
    public int countReportsByPost(Long postId) {
        return reportRepository.countByPostId(postId);
    }
}