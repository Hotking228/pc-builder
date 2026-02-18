package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.ProductCreateEditDto;
import com.hotking.pcbuilder.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FromCreateProductDtoToProductMapper implements Mapper<ProductCreateEditDto, Product>{

    private final FromCategoryDtoToCategoryMapper categoryMapper;
    private final FromSpecificationsReadDtoToSpecifications specMapper;

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
