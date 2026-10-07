package com.adoption.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequest {

    @NotNull(message = "L'id du post est obligatoire")
    private Long postId;

    @NotBlank(message = "Le commentaire est obligatoire")
    private String content;
    // les autres champs: userId du token et created at prepersist
}