package br.com.mondialgroup.marketinsights.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MarketplaceRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve contar no máximo 100 caracteres")
        String name,
        String abbreviation
) {
}
