package br.com.mondialgroup.marketinsights.dto.request;

public record ProductRequest(String sku,
                             String name,
                             Long brand,
                             Long category,
                             String feature1,
                             String feature2,
                             String feature3) {
}
