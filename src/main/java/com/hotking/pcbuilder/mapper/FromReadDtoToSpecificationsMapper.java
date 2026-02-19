package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.SpecificationReadDto;
import com.hotking.pcbuilder.entity.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FromReadDtoToSpecificationsMapper implements Mapper<List<SpecificationReadDto>, List<Specification>> {
    @Override
    public List<Specification> map(List<SpecificationReadDto> object) {
        return object.stream()
                .map(dto -> Specification.builder()
                        .specKey(dto.getSpecKey())
                        .specValue(dto.getSpecValue())
                        .build())
                .toList();

    }
}
