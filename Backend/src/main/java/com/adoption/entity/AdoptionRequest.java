package com.adoption.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "adoption_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Status status=Status.pending;

    public enum Status { pending,accepted,rejected,cancelled}
    // Message de présentation
    @Column(columnDefinition = "TEXT")
    private String message;

    // Déjà eu des animaux ?
    @Column(name = "has_experience", nullable = false)
    private Boolean hasExperience;

    // Type de logement
    @Enumerated(EnumType.STRING)
    @Column(name = "housing_type", nullable = false)
    private HousingType housingType;

    // Jardin ?
    @Column(name = "has_garden", nullable = false)
    private Boolean hasGarden;

    // Enfants ?
    @Column(name = "has_children", nullable = false)
    private Boolean hasChildren;

    // Numéro de téléphone
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public enum HousingType {
        maison, appartement, villa, autre
    }
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt=LocalDateTime.now();
        updatedAt=LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt= LocalDateTime.now();
    }
}
