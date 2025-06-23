package br.com.mondialgroup.marketinsights.dto.response;

import lombok.Builder;

@Builder
public record BrandResponse(Long  id, String name) {
}
