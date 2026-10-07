package com.adoption.repository;

import com.adoption.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository  extends JpaRepository<Post,Long> {
    long countByStatus(Post.Status status);

    //pour retrouver tous les post d'un utlisateur par son ID
    List<Post> findByUserId(Long userId);
    // pour retrouver le post disponible par status (available)
    List<Post> findByStatus(Post.Status status);
    // faire une recherche par category
    List<Post> findByCategory(String category);
    //recherche par ville
    List<Post> findByCity(Post.City city);
    //Post d'adoptation vrai
    List<Post> findByIsAdoptionTrue();
    //Post de donnation seulment
    List<Post> findByIsDonationIsTrue();
    @Query("SELECT p FROM Post p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Post> searchByKeyword(@Param("keyword") String keyword);
    void deleteByUserId(Long userId);
    long countByUserId(Long userId);
    List<Post> findTop5ByOrderByCreatedAtDesc();


}
