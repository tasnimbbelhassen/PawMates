package com.adoption.controller;

import com.adoption.dto.DonationRequest;
import com.adoption.entity.Donation;
import com.adoption.entity.User;
import com.adoption.service.DonationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/donations")
@RequiredArgsConstructor

public class DonationController {

    private final DonationService donationService;

    // Faire un don
    @PostMapping
    public ResponseEntity<Donation> createDonation(
            @Valid @RequestBody DonationRequest request,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                donationService.createDonation(request, currentUser));
    }

    // Voir mes donations faites
    @GetMapping("/my-donations")
    public ResponseEntity<List<Donation>> getMyDonations(
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                donationService.getMyDonations(currentUser));
    }

    // Voir les donations reçues
    @GetMapping("/received")
    public ResponseEntity<List<Donation>> getReceivedDonations(
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                donationService.getReceivedDonations(currentUser));
    }

    // Voir les donations d'un post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Donation>> getDonationsByPost(
            @PathVariable Long postId,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                donationService.getDonationsByPost(postId, currentUser));
    }

    // Voir le total des donations d'un post
    @GetMapping("/post/{postId}/total")
    public ResponseEntity<BigDecimal> getTotalDonationsByPost(
            @PathVariable Long postId,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(
                donationService.getTotalDonationsByPost(postId, currentUser));
    }

    // Nombre de donations d'un post
    @GetMapping("/post/{postId}/count")
    public ResponseEntity<Integer> countDonationsByPost(
            @PathVariable Long postId) {
        return ResponseEntity.ok(
                donationService.countDonationsByPost(postId));
    }
}