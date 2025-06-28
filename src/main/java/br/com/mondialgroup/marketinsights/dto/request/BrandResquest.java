package br.com.mondialgroup.marketinsights.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BrandResquest(
        @NotBlank(message = "O nome da marca é obrigatório")
        @Size(max = 100, message = "O nome da marca deve conter no máximo 50 caracteres")
        String name
) {
}
