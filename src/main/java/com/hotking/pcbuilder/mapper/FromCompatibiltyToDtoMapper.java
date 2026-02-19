package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.CompatibilityDto;
import com.hotking.pcbuilder.entity.CompatibilityRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FromCompatibiltyToDtoMapper implements Mapper<CompatibilityRule, CompatibilityDto>{

    private final FromCategoryToDtoMapper categoryMapper;

    @Override
    public CompatibilityDto map(CompatibilityRule object) {
        return CompatibilityDto.builder()
                .value(object.getValue())
                .sourceCategory(categoryMapper.map(object.getSourceCategory()))
                .targetCategory(categoryMapper.map(object.getTargetCategory()))
                .sourceSpecKey(object.getSourceSpecKey())
                .targetSpecKey(object.getTargetSpecKey())
                .operator(object.getOperator())
                .build();
    }
}
