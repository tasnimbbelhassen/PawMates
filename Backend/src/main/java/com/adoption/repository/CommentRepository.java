package com.adoption.repository;

import com.adoption.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Commentaires non supprimés d'un post
    List<Comment> findByPostIdAndDeletedAtIsNull(Long postId);

    // Commentaires non supprimés d'un utilisateur
    List<Comment> findByUserIdAndDeletedAtIsNull(Long userId);
    void deleteByPostId(Long postId);
    void deleteByPostUserId(Long userId);
    // Nombre de commentaires non supprimés d'un post
    int countByPostIdAndDeletedAtIsNull(Long postId);
}