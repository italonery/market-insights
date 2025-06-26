package br.com.mondialgroup.marketinsights.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProductResponse(Long id,
                              String sku,
                              String name,
                              BrandResponse brand,
                              CategoryResponse category,
                              String feature1,
                              String feature2,
                              String feature3) {
}
