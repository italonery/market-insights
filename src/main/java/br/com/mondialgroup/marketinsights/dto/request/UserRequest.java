package br.com.mondialgroup.marketinsights.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "O usuário é obrigatório")
        @Size(
                min = 5,
                max = 20,
                message = "O usuário deve conter no mínimo 5 e no máximo 20 caracteres"
        )
        String username,

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O e-mail é obrigatório")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        String password
) {
}
