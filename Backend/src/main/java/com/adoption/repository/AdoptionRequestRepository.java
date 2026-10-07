package com.adoption.repository;

import com.adoption.entity.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest,Long> {
   // toutes les demandes d'un post(propriétaire ouvre son post → voit la liste des demandeurs)
   List<AdoptionRequest> findByPostId(Long postId);
   // toutes les demandes faire par un utilisateur(Utilisé dans le profil de l'utilisateur → "Mes demandes envoyées")
    List<AdoptionRequest> findByRequesterId(Long requeterId);
    // toutes les demandes recues par propitaire(Utilisé dans le profil du propriétaire → "Demandes reçues "=> Exemple : Ali voit toutes les demandes sur tous ses posts)
    List<AdoptionRequest> findByOwnerId( Long ownerId);
    //toutes les demandes d'un post avec un status precisRécupère les demandes d'un post filtrées par * Utilisé quand le propriétaire accepte une demande
    List<AdoptionRequest> findByPostIdAndStatus(Long postId,AdoptionRequest.Status status );
    // verifier si l'utilisateur a deja demandée pour ce post
    Boolean existsByPostIdAndRequesterId(Long postId, Long requesterId);
    void deleteByPostId(Long postId);
    @Modifying
    @Query("DELETE FROM AdoptionRequest a WHERE a.post.user.id = :userId")
    void deleteByPostUserId(@Param("userId") Long userId);

    void deleteByRequesterId(Long requesterId);

    // Supprimer par owner
    void deleteByOwnerId(Long ownerId);

    // Compter par requester
    long countByRequesterId(Long requesterId);


}
