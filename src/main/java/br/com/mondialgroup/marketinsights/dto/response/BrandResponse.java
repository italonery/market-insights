package br.com.mondialgroup.marketinsights.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record BrandResponse(
        @Schema(type = "long", description = "ID da Marca")
        Long id,

        @Schema(type = "string", description = "Nome da Marca")
        String name
) {
}
