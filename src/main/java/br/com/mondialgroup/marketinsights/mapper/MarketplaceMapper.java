package br.com.mondialgroup.marketinsights.mapper;

import br.com.mondialgroup.marketinsights.dto.request.MarketplaceRequest;
import br.com.mondialgroup.marketinsights.dto.response.MarketplaceResponse;
import br.com.mondialgroup.marketinsights.model.Marketplace;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MarketplaceMapper {

    public static Marketplace toMarketplace(MarketplaceRequest marketplaceRequest) {
        return Marketplace.builder()
                .name(marketplaceRequest.name())
                .abbreviation(marketplaceRequest.abbreviation())
                .build();
    }

    public static MarketplaceResponse toMarketplaceResponse(Marketplace marketplace) {
        return MarketplaceResponse.builder()
                .id(marketplace.getId())
                .name(marketplace.getName())
                .abbreviation(marketplace.getAbbreviation())
                .build();
    }
}
