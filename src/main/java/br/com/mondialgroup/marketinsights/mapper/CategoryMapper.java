package br.com.mondialgroup.marketinsights.mapper;

import br.com.mondialgroup.marketinsights.dto.request.CategoryRequest;
import br.com.mondialgroup.marketinsights.dto.response.CategoryResponse;
import br.com.mondialgroup.marketinsights.model.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.name())
                .description(categoryRequest.description())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
