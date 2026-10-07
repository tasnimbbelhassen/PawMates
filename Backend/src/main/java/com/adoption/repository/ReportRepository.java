package com.adoption.repository;

import com.adoption.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
    long countByStatus(Report.Status status);

    //recuperer tous les signals d'un post
    List<Report> findByPostId(Long postId);
    // tous les signalment fait par un utlisateur
    List<Report> findByReporterId(Long reporterId);
    // tous les signal par status(pour l'admin)
    List<Report> findByStatus(Report.Status status);
    // verifier si un utlisateur a deja signalé un post
    Boolean existsByPostIdAndReporterId(Long postId, Long reporterId);
    // nb de signal d'un post
    int countByPostId(Long postId);
    void deleteByPostId(Long postId);
    void deleteByPostUserId(Long userId);
}
