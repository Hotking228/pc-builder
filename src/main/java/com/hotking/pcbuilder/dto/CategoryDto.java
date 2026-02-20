package com.hotking.pcbuilder.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    Long id;

    String name;

    String slug;

    String description;
}
