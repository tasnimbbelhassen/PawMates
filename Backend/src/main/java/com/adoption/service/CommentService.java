package com.adoption.service;

import com.adoption.dto.CommentRequest;
import com.adoption.entity.Comment;
import com.adoption.entity.Post;
import com.adoption.entity.User;
import com.adoption.repository.CommentRepository;
import com.adoption.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // Créer un commentaire
    public Comment createComment(CommentRequest request, User currentUser) {

        // Récupérer le post
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post non trouvé"));

        // Vérifier que le post est disponible
        if (post.getStatus() == Post.Status.removed) {
            throw new RuntimeException("Ce post n'est plus disponible !");
        }

        // Créer le commentaire
        Comment comment = Comment.builder()
                .user(currentUser)
                .post(post)
                .content(request.getContent())
                .build();

        return commentRepository.save(comment);
    }

    // Voir les commentaires d'un post
    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepository.findByPostIdAndDeletedAtIsNull(postId);
    }

    // Voir mes commentaires
    public List<Comment> getMyComments(User currentUser) {
        return commentRepository.findByUserIdAndDeletedAtIsNull(currentUser.getId());
    }

    // Nombre de commentaires d'un post
    public int countCommentsByPost(Long postId) {
        return commentRepository.countByPostIdAndDeletedAtIsNull(postId);
    }

    // Modifier un commentaire
    public Comment updateComment(Long commentId, String content, User currentUser) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));

        // Vérifier que c'est bien l'auteur
        if (!comment.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Vous n'êtes pas autorisé à modifier ce commentaire !");
        }

        // Vérifier que le commentaire n'est pas supprimé
        if (comment.getDeletedAt() != null) {
            throw new RuntimeException("Ce commentaire a été supprimé !");
        }

        comment.setContent(content);
        return commentRepository.save(comment);
    }

    // Supprimer un commentaire (soft delete)
    public void deleteComment(Long commentId, User currentUser) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));

        // Vérifier que c'est l'auteur OU le propriétaire du post OU admin
        boolean isAuthor = comment.getUser().getId().equals(currentUser.getId());
        boolean isPostOwner = comment.getPost().getUser().getId()
                .equals(currentUser.getId());
        boolean isAdmin = currentUser.getRole() == User.Role.admin;

        if (!isAuthor && !isPostOwner && !isAdmin) {
            throw new RuntimeException(
                    "Vous n'êtes pas autorisé à supprimer ce commentaire !");
        }

        // Soft delete → on met juste la date de suppression
        comment.setDeletedAt(LocalDateTime.now());
        commentRepository.save(comment);
    }
}