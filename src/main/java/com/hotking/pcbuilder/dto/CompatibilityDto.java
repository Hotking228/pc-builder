package com.hotking.pcbuilder.dto;

import com.hotking.pcbuilder.enums.Operator;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompatibilityDto {


    private CategoryDto sourceCategory;

    private CategoryDto targetCategory;

    private String sourceSpecKey;

    private String targetSpecKey;

    @Enumerated(EnumType.STRING)
    private Operator operator;

    private String value;
}
