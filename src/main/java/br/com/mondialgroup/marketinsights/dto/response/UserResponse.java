package br.com.mondialgroup.marketinsights.dto.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String username, String name, String email) {
}
