package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.ProductCreateEditDto;
import com.hotking.pcbuilder.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FromCreateDtoToProductMapper implements Mapper<ProductCreateEditDto, Product>{

    private final FromDtoToCategoryMapper categoryMapper;
    private final FromReadDtoToSpecificationsMapper specMapper;

    @Override
    public Product map(ProductCreateEditDto dto, Product entity){
        return Product.builder()
                .name(dto.getName())
                .vendorCode(dto.getVendorCode())
                .price(dto.getPrice())
                .category(categoryMapper.map(dto.getCategory()))
                .manufacturer(dto.getManufacturer())
                .specifications(specMapper.map(dto.getSpecifications()))
                .id(entity.getId())
                .build();
    }

    @Override
    public Product map(ProductCreateEditDto object) {
        return Product.builder()
                .name(object.getName())
                .vendorCode(object.getVendorCode())
                .price(object.getPrice())
                .category(categoryMapper.map(object.getCategory()))
                .manufacturer(object.getManufacturer())
                .specifications(specMapper.map(object.getSpecifications()))
                .build();
    }
}
