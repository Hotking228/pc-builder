package com.hotking.pcbuilder.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    String name;

    String slug;

    String description;
}
