package com.adoption.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private Long id;
    private String token;//token JWT que Vue.js va stocker et envoyer à chaque requête
    private String name;//Pour afficher le nom de l'utilisateur dans l'interface
    private String email;//Pour identifier l'utilisateur côté frontend
    private String role;//Pour savoir si c'est un user ou admin et afficher le bon menu
}
