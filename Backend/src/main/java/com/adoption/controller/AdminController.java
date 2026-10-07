package com.adoption.controller;

import com.adoption.entity.Post;
import com.adoption.entity.User;
import com.adoption.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('admin')")
public class AdminController {

    private final AdminService adminService;


    // GESTION DES UTILISATEURS


    // Voir tous les utilisateurs
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    // Promouvoir un user en admin
    @PatchMapping("/users/{id}/promote")
    public ResponseEntity<User> promoteToAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.promoteToAdmin(id));
    }

    // Rétrograder un admin en user
    @PatchMapping("/users/{id}/demote")
    public ResponseEntity<User> demoteToUser(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.demoteToUser(id));
    }


    // GESTION DES POSTS


    // Voir tous les posts
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(adminService.getAllPosts());
    }

    // Voir les posts par status
    @GetMapping("/posts/status/{status}")
    public ResponseEntity<List<Post>> getPostsByStatus(
            @PathVariable Post.Status status) {
        return ResponseEntity.ok(adminService.getPostsByStatus(status));
    }
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getStatistics() {
        return ResponseEntity.ok(adminService.getStatistics());
    }

    // STATISTIQUES

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/users/{id}/stats")
    public ResponseEntity<?> getUserStats(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getUserStats(id));
    }
}