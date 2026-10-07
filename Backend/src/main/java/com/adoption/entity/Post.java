package com.adoption.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    @Column(nullable = false)
    private String category;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private City city=City.Bizerte;

    public enum City{
        Tunis, Sfax, Sousse, Kairouan, Bizerte,
        Gabes, Ariana, Gafsa, Monastir, Ben_Arous,
        Kasserine, Medenine, Nabeul, Tataouine,
        Beja, Jendouba, El_Kef, Mahdia,
        Sidi_Bouzid, Siliana, Zaghouan,
        Tozeur, Manouba, Kebili
    }
    @Column(name = "localisation_detail")
    private String localisationDetail;

    @Column(name = "is_donnation", nullable = false)
    @Builder.Default
    private Boolean isDonation=false;

    @Column(name = "is_adoption", nullable = false)
    private Boolean isAdoption=true;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Status status=Status.available;


    public enum Status{ available, adopted, removed,closed}
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name ="updated_at")
    private  LocalDateTime updatedAt;

    @PrePersist
    protected void onnCreate(){
        createdAt=LocalDateTime.now();
        updatedAt=LocalDateTime.now();
    }

    @PreUpdate
    protected  void onUpdate(){
        updatedAt=LocalDateTime.now();
    }




}
