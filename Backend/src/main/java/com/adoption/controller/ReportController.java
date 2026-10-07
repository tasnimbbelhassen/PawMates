package com.adoption.controller;

import com.adoption.dto.ReportRequest;
import com.adoption.entity.Report;
import com.adoption.entity.User;
import com.adoption.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor

public class ReportController {

    private final ReportService reportService;

    // Créer un signalement — connecté
    @PostMapping
    public ResponseEntity<Report> createReport(
            @Valid @RequestBody ReportRequest request,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                reportService.createReport(request, currentUser));
    }

    // Voir tous les signalements — admin
    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<List<Report>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    // Voir les signalements par status — admin
    @GetMapping("/status/{status}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<List<Report>> getReportsByStatus(
            @PathVariable Report.Status status) {
        return ResponseEntity.ok(reportService.getReportsByStatus(status));
    }

    // Voir les signalements d'un post — admin
    @GetMapping("/post/{postId}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<List<Report>> getReportsByPost(
            @PathVariable Long postId) {
        return ResponseEntity.ok(reportService.getReportsByPost(postId));
    }

    // Mettre en cours de traitement — admin
    @PatchMapping("/{id}/review")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Report> reviewReport(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.reviewReport(id));
    }

    // Valider et supprimer le post — admin
    @PatchMapping("/{id}/resolve")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Report> resolveReport(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.resolveReport(id));
    }

    // Ignorer le signalement — admin
    @PatchMapping("/{id}/dismiss")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Report> dismissReport(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.dismissReport(id));
    }

    // Nombre de signalements d'un post — admin
    @GetMapping("/post/{postId}/count")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Integer> countReportsByPost(
            @PathVariable Long postId) {
        return ResponseEntity.ok(reportService.countReportsByPost(postId));
    }
}