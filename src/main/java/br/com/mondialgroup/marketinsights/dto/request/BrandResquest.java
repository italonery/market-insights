package br.com.mondialgroup.marketinsights.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BrandResquest(
        @Schema(type = "string", description = "Nome da Marca")
        @NotBlank(message = "O nome da marca é obrigatório")
        @Size(max = 100, message = "O nome da marca deve conter no máximo 50 caracteres")
        String name
) {
}
