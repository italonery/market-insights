package br.com.mondialgroup.marketinsights.mapper;

import br.com.mondialgroup.marketinsights.dto.request.BrandResquest;
import br.com.mondialgroup.marketinsights.dto.response.BrandResponse;
import br.com.mondialgroup.marketinsights.model.Brand;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BrandMapper {

    public static Brand toBrand(BrandResquest brandResquest) {
        return Brand.builder()
                .name(brandResquest.name())
                .build();
    }

    public static BrandResponse toBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }
}
