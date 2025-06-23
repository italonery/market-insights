package br.com.mondialgroup.marketinsights.dto.response;

import lombok.Builder;

@Builder
public record MarketplaceResponse(Long id, String name, String abbreviation) {
}
