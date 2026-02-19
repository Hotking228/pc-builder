package com.hotking.pcbuilder.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductCreateEditDto {

    String name;

    String vendorCode;

    Float price;

    CategoryDto category;

    String manufacturer;

    List<SpecificationReadDto> specifications;
}
