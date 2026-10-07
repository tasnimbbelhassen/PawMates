package com.adoption.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
// ya moez => DTO: c'est un objet pour envoyer seulement les données nécessaires au utilisateur
@Data
public class RegisterRequest {
    @NotBlank(message=" le nom est obligatoire")
    private String name;
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email n'est pas valide")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "le mot de passe doit contenir au moins 6 caractères")
    private String password;

    private String phone;
}
