package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.SpecificationReadDto;
import com.hotking.pcbuilder.entity.Specification;
import org.springframework.stereotype.Component;

@Component
public class FromSpecificationToReadDtoMapper implements Mapper<Specification, SpecificationReadDto>{
    @Override
    public SpecificationReadDto map(Specification object) {
        return SpecificationReadDto.builder()
                .specKey(object.getSpecKey())
                .specValue(object.getSpecValue())
                .build();
    }
}
