package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.CategoryDto;
import com.hotking.pcbuilder.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class FromCategoryToDtoMapper implements Mapper<Category, CategoryDto>{
    @Override
    public CategoryDto map(Category object) {
        return CategoryDto.builder()
                .name(object.getName())
                .slug(object.getSlug())
                .description(object.getDescription())
                .build();
    }
}
