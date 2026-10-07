package com.adoption.controller;

import com.adoption.dto.AuthResponse;
import com.adoption.dto.LoginRequest;
import com.adoption.dto.RegisterRequest;
import com.adoption.entity.User;
import com.adoption.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getMe(
            @AuthenticationPrincipal User currentUser) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", currentUser.getId());
        response.put("name", currentUser.getName());
        response.put("email", currentUser.getEmail());
        response.put("role", currentUser.getRole().name());
        response.put("phone", currentUser.getPhone());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout() {
        // JWT est stateless — le vrai logout se fait côté frontend
        // en supprimant le token du localStorage
        return ResponseEntity.ok(Map.of("message", "Déconnexion réussie"));
    }
}