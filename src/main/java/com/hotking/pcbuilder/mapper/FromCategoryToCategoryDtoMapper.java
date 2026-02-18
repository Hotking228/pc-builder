package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.ProductCategoryDto;
import com.hotking.pcbuilder.entity.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class FromCategoryToCategoryDtoMapper implements Mapper<ProductCategory, ProductCategoryDto>{
    @Override
    public ProductCategoryDto map(ProductCategory object) {
        return ProductCategoryDto.builder()
                .name(object.getName())
                .slug(object.getSlug())
                .description(object.getDescription())
                .build();
    }
}
