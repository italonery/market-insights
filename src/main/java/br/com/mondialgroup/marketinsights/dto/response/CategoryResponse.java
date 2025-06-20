package br.com.mondialgroup.marketinsights.dto.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name, String description) {
}
