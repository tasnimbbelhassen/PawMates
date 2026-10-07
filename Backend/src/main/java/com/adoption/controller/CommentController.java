package com.adoption.controller;

import com.adoption.dto.CommentRequest;
import com.adoption.entity.Comment;
import com.adoption.entity.User;
import com.adoption.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;

    // Créer un commentaire
    @PostMapping
    public ResponseEntity<Comment> createComment(
            @Valid @RequestBody CommentRequest request,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                commentService.createComment(request, currentUser));
    }

    // Voir les commentaires d'un post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(
            @PathVariable Long postId) {
        return ResponseEntity.ok(
                commentService.getCommentsByPost(postId));
    }

    // Voir mes commentaires
    @GetMapping("/my-comments")
    public ResponseEntity<List<Comment>> getMyComments(
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                commentService.getMyComments(currentUser));
    }

    // Nombre de commentaires d'un post
    @GetMapping("/post/{postId}/count")
    public ResponseEntity<Integer> countCommentsByPost(
            @PathVariable Long postId) {
        return ResponseEntity.ok(
                commentService.countCommentsByPost(postId));
    }

    // Modifier un commentaire
    @PatchMapping("/{id}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable Long id,
            @RequestBody String content,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                commentService.updateComment(id, content, currentUser));
    }

    // Supprimer un commentaire
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long id,
            @AuthenticationPrincipal User currentUser) {
        commentService.deleteComment(id, currentUser);
        return ResponseEntity.ok().build();
    }
}