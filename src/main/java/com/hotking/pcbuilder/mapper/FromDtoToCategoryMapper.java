package com.hotking.pcbuilder.mapper;


import com.hotking.pcbuilder.dto.CategoryDto;
import com.hotking.pcbuilder.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class FromDtoToCategoryMapper implements Mapper<CategoryDto, Category>{


    @Override
    public Category map(CategoryDto object) {
        return Category.builder()
                .name(object.getName())
                .slug(object.getSlug())
                .description(object.getDescription())
                .build();
    }

    @Override
    public Category map(CategoryDto object, Category entity) {
        return Category.builder()
                .name(object.getName())
                .slug(object.getSlug())
                .description(object.getDescription())
                .id(entity.getId())
                .products(entity.getProducts())
                .build();
    }
}
