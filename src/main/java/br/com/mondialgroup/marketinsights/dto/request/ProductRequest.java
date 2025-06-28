package br.com.mondialgroup.marketinsights.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "O SKU do produto é obrigatório")
        @Size(max = 50, message = "O SKU deve conter no máximo 50 caracteres")
        String sku,

        @NotBlank(message = "O nome do produto é obrigatório")
        @Size(max = 100, message = "O nome deve conter no máximo 100 caracteres")
        String name,

        @NotNull(message = "A marca do produto é obrigatória")
        Long brand,

        @NotNull(message = "A categoria do produto é obrigatória")
        Long category,

        String feature1,
        String feature2,
        String feature3
) {
}
