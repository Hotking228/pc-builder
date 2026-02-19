package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.SpecificationReadDto;
import com.hotking.pcbuilder.entity.Specification;
import org.springframework.stereotype.Component;

@Component
public class FromDtoToSpecMapper implements Mapper<SpecificationReadDto, Specification>{
    @Override
    public Specification map(SpecificationReadDto object) {
        return null;
    }

    @Override
    public Specification map(SpecificationReadDto object, Specification entity) {
        return Specification.builder()
                .id(entity.getId())
                .specKey(object.getSpecKey())
                .specValue(object.getSpecValue())
                .build();
    }
}
