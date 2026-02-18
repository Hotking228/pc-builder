package com.hotking.pcbuilder.mapper;


import com.hotking.pcbuilder.dto.ProductCategoryDto;
import com.hotking.pcbuilder.entity.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class FromCategoryDtoToCategoryMapper implements Mapper<ProductCategoryDto, ProductCategory>{
    @Override
    public ProductCategory map(ProductCategoryDto object) {
        return ProductCategory.builder()
                .name(object.getName())
                .slug(object.getSlug())
                .description(object.getDescription())
                .build();
    }
}
