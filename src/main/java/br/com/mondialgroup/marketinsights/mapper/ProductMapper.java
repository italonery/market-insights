package br.com.mondialgroup.marketinsights.mapper;

import br.com.mondialgroup.marketinsights.dto.request.ProductRequest;
import br.com.mondialgroup.marketinsights.dto.response.BrandResponse;
import br.com.mondialgroup.marketinsights.dto.response.CategoryResponse;
import br.com.mondialgroup.marketinsights.dto.response.ProductResponse;
import br.com.mondialgroup.marketinsights.model.Brand;
import br.com.mondialgroup.marketinsights.model.Category;
import br.com.mondialgroup.marketinsights.model.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

    public static Product toProduct(ProductRequest productRequest) {
        Brand brand = Brand.builder().id(productRequest.brand()).build();
        Category category = Category.builder().id(productRequest.category()).build();

        return Product.builder()
                .sku(productRequest.sku())
                .name(productRequest.name())
                .brand(brand)
                .category(category)
                .feature1(productRequest.feature1())
                .feature2(productRequest.feature2())
                .feature3(productRequest.feature3())
                .build();
    }

    public static ProductResponse toProductResponse(Product product) {
        BrandResponse brand = BrandMapper.toBrandResponse(product.getBrand());
        CategoryResponse category = CategoryMapper.toCategoryResponse(product.getCategory());

        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .brand(brand)
                .category(category)
                .feature1(product.getFeature1())
                .feature2(product.getFeature2())
                .feature3(product.getFeature3())
                .build();
    }
}
