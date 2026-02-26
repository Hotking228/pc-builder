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
public class ProductReadDto {

    String name;

    Float price;

    String manufacturer;

    CategoryDto category;

    List<SpecificationReadDto> specifications;
}
