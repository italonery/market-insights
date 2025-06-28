package br.com.mondialgroup.marketinsights.security;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String username) {
}
