package com.hotking.pcbuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateEditDto {

    String name;

    String vendorCode;

    Float price;

    CategoryDto category;

    String manufacturer;

    List<SpecificationReadDto> specifications;
}
