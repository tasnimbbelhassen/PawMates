package com.adoption.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DonationRequest {

    @NotNull(message = "L'id du post est obligatoire")
    private Long postId;

    @NotNull(message = "Le montant est obligatoire")
    @DecimalMin(value = "1.0", message = "Le montant minimum est 1 DT")
    private BigDecimal amount;

    @NotBlank(message = "Le numéro de carte est obligatoire")
    @Size(min = 16, max = 16, message = "Le numéro de carte doit contenir 16 chiffres")
    private String cardNumber;

    @NotBlank(message = "Le nom du titulaire est obligatoire")
    private String cardHolderName;
}