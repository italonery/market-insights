package br.com.mondialgroup.marketinsights.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank(message = "O nome da categoria é obrigatório")
        @Size(max = 50, message = "O nome da categoria deve conter no máximo 50 caracteres")
        String name,

        @Size(max = 200, message = "A descrição deve conter no máximo 200 caracteres")
        String description
) {
}
