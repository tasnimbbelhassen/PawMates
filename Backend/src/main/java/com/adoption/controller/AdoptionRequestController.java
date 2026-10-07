package com.adoption.controller;

import com.adoption.dto.AdoptionRequestRequest;
import com.adoption.entity.AdoptionRequest;
import com.adoption.entity.User;
import com.adoption.service.AdoptionRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoption_requests")
@RequiredArgsConstructor

public class AdoptionRequestController {
private final AdoptionRequestService adoptionRequestService;
//ceer une demande d'adoptation
@PostMapping
public ResponseEntity<AdoptionRequest> createRequest(@Valid @RequestBody AdoptionRequestRequest request, @AuthenticationPrincipal User currentUser){
    return ResponseEntity.ok(adoptionRequestService.createRequest(request,currentUser)) ;
}
//voir les demandes recus
    @GetMapping("/received")
    public ResponseEntity<List<AdoptionRequest>> getRecievedRequests(@AuthenticationPrincipal User currentUser){
    return ResponseEntity.ok(adoptionRequestService.getRecievedRequests(currentUser));
    }
// voir les demandes envoyées
    @GetMapping("/sent")
public  ResponseEntity<List<AdoptionRequest>> getSentRequests(@AuthenticationPrincipal User currentUser){
    return ResponseEntity.ok(adoptionRequestService.getSentRequest(currentUser));
}
// voir les demandes d'un post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<AdoptionRequest>> getRequestsByPost(@PathVariable Long postId, @AuthenticationPrincipal User currentUser){
    return ResponseEntity.ok(adoptionRequestService.getRequestesByPost(postId,currentUser));
    }
//Accepter une demande
@PatchMapping("/{id}/accept")
public ResponseEntity<AdoptionRequest> acceptRequest(@PathVariable Long id, @AuthenticationPrincipal User currentUser) {
    return ResponseEntity.ok(adoptionRequestService.accepteRequest(id, currentUser));
}
// refuser une demande
@PatchMapping("/{id}/reject")
public ResponseEntity<AdoptionRequest> rejectRequest(@PathVariable Long id, @AuthenticationPrincipal User currentUser) {
    return ResponseEntity.ok(adoptionRequestService.rejectRequest(id, currentUser));
}
//Annuler une demande
@PatchMapping("/{id}/cancel")
public ResponseEntity<AdoptionRequest> cancelRequest(
        @PathVariable Long id,
        @AuthenticationPrincipal User currentUser) {
    return ResponseEntity.ok(
            adoptionRequestService.cancelRequest(id, currentUser));
}
}
