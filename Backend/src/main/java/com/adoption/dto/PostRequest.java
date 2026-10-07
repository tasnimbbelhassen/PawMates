package com.adoption.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// avec ce Dto il contien,t seulment que l'utlisateur le doit envoyée
@Data
public class PostRequest {
    @NotBlank(message = "le titre est obligatoire")
    private String title;
    @NotBlank(message = "la description est obligatoire")
    private String description;
    @NotBlank(message = "l'image est obligatoire")
    private String image;
    @NotBlank(message = "la category est obligatoire")
    private String category;
    @NotBlank(message = "le  city  est obligatoire")
    private String city;

    private String localisation_detail;
    @NotNull(message = "is_donation est obligatoire")
    private Boolean isDonation;
    @NotNull(message = "is_adoption est obligatoire")
    private Boolean isAdoption;

    private String cardNumber;
    private String cardHolderName;
}
