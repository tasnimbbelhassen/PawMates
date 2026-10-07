package com.adoption.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdoptionRequestRequest {
    @NotNull(message = "l'id du post est obligatoire")
    private Long postId;
    @NotBlank(message = "le message de presentation est obligatoire")
    private String message;
    @NotNull(message = "Veuillez indiquer si vous avez deja eu des animaux")
    private Boolean hasExperience;
    @NotNull(message = "Veuillez indiquer le type de longement svp")
    private String housingType;
    @NotNull(message = "Veuillez indiquer si vous avez un jardin")
    private Boolean hasGarden;
    @NotNull(message = "Veuillez indiquer si vous avez des enfants")
    private Boolean hasChildren;
    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    private String phoneNumber;
}
