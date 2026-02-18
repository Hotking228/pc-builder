package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.ProductReadDto;
import com.hotking.pcbuilder.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FromProductToProductReadDtoMapper implements Mapper<Product, ProductReadDto> {

    private final FromCategoryToCategoryDtoMapper categoryMapper;

    @Override
    public ProductReadDto map(Product object) {
        return ProductReadDto.builder()
                .price(object.getPrice())
                .name(object.getName())
                .manufacturer(object.getManufacturer())
                .category(categoryMapper.map(object.getCategory()))
                .build();

    }
}
