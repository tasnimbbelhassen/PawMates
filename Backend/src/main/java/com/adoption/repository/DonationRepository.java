package com.adoption.repository;

import com.adoption.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {
    // toutes les donnation d'une post
    List<Donation> findByPostId(Long postId);
    // toutes les donnation faites par un utlisateur
    List<Donation> findByUserId(Long userId);
    // toutes les donnation recues par un propritaire
    List<Donation> findByOwnerId(Long ownerId);

    //chercher une donnation par transaction_id
    Optional<Donation> findByTransactionId(String transactionId);
    // nombre des donnation par une post
    int countByPostId(Long postId);
    // somme totale des donnation par une post
    @Query("SELECT SUM(d.amount) FROM Donation d WHERE d.post.id = :postId")
    BigDecimal sumAmountByPostId(@Param("postId") Long postId);
    void deleteByPostId(Long postId);
    void deleteByPostUserId(Long userId);
    void deleteByUserId(Long userId);
    long countByUserId(Long userId);

}
