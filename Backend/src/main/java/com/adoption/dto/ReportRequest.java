package com.adoption.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReportRequest {

    @NotNull(message = "L'id du post est obligatoire")
    private Long postId;

    @NotBlank(message = "La raison est obligatoire")
    private String reason;
}