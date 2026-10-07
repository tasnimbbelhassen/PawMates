package com.adoption.controller;

import com.adoption.dto.PostRequest;
import com.adoption.entity.Post;
import com.adoption.entity.User;
import com.adoption.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor

public class PostController {
    private final PostService postService;
    // voir tous les posts-public
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // voir un post par id - public
    @GetMapping("/{id}")
    public  ResponseEntity<Post> getPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    // voir mes posts- user connecte
    @GetMapping("/my-posts")
    public  ResponseEntity<List<Post>> getMyPosts(@AuthenticationPrincipal User currentUser){
        return ResponseEntity.ok(postService.getMyPosts(currentUser));
    }
    // voir les posts d'adoptation-public
    @GetMapping("/adoption")
    public ResponseEntity<List<Post>> getAdoptionPosts(){
        return  ResponseEntity.ok(postService.getAdoptionPosts());
    }
    // voir les posts des donnation-public
    @GetMapping("/donation")
    public ResponseEntity<List<Post>> getDonationPosts(){
        return ResponseEntity.ok(postService.getDonationPosts());
    }
    // rechercher par categorie-public
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable String category){
        return  ResponseEntity.ok(postService.getPostsByCategory(category));
    }
    //rechercher par ville-public
    @GetMapping("/city/{city}")
    public  ResponseEntity<List<Post>> getPostsByCity(@PathVariable String city){
        return ResponseEntity.ok(postService.getPostsByCity(city));
    }
    // creer un post -connecté
    @PostMapping
    public  ResponseEntity<Post> createPost(@Valid @RequestBody PostRequest request, @AuthenticationPrincipal User currentUser){
        return ResponseEntity.ok(postService.createPost(request,currentUser));
    }
    //Modifier une post - seulment le propritaire du post
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody PostRequest request, @AuthenticationPrincipal User currentUser){
        return ResponseEntity.ok(postService.updatePost(id,request,currentUser));
    }
    // fermer un post-seulment le propraitaire du post
    @PatchMapping("/close/{id}")
    public  ResponseEntity<Post> closePost(@PathVariable Long id , @AuthenticationPrincipal User currentUser){
        return ResponseEntity.ok(postService.closePost(id,currentUser));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id, @AuthenticationPrincipal User currentUser) {
        postService.deletePost(id, currentUser);
        return ResponseEntity.noContent().build();
    }

    //supprimer un post-admin seul
    @PatchMapping("/{id}/remove")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Void> removePost(@PathVariable Long id){
        postService.removePost(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<Post>> searchPosts(
            @RequestParam(required = false) String keyword) {
        return ResponseEntity.ok(postService.searchPosts(keyword));
    }
}
