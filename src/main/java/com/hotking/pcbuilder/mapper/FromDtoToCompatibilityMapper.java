package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.CompatibilityDto;
import com.hotking.pcbuilder.entity.CompatibilityRule;
import org.springframework.stereotype.Component;

@Component
public class FromDtoToCompatibilityMapper implements Mapper<CompatibilityDto, CompatibilityRule>{

    FromDtoToCategoryMapper dtoMapper;

    @Override
    public CompatibilityRule map(CompatibilityDto object) {
        return CompatibilityRule.builder()
                .value(object.getValue())
                .sourceCategory(dtoMapper.map(object.getSourceCategory()))
                .targetCategory(dtoMapper.map(object.getTargetCategory()))
                .sourceSpecKey(object.getSourceSpecKey())
                .targetSpecKey(object.getTargetSpecKey())
                .operator(object.getOperator())
                .build();
    }

    @Override
    public CompatibilityRule map(CompatibilityDto object, CompatibilityRule entity) {
        return CompatibilityRule.builder()
                .value(object.getValue())
                .value(object.getValue())
                .sourceCategory(dtoMapper.map(object.getSourceCategory()))
                .targetCategory(dtoMapper.map(object.getTargetCategory()))
                .sourceSpecKey(object.getSourceSpecKey())
                .targetSpecKey(object.getTargetSpecKey())
                .operator(object.getOperator())
                .id(entity.getId())
                .build();
    }
}
