package com.adoption.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "donor_card_last_four", nullable = false, length = 4)
    private String donorCardLastFour;

    @Column(name = "donor_card_holder_name", nullable = false)
    private String donorCardHolderName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
 //pour se genere automatiquement
    @Column(name = "transaction_id", nullable = false, unique = true)
    @Builder.Default
    private String transactionId = java.util.UUID.randomUUID().toString();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
