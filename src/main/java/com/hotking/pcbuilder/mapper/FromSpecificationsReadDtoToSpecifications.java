package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.SpecificationReadDto;
import com.hotking.pcbuilder.entity.ProductSpecification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class FromSpecificationsReadDtoToSpecifications implements Mapper<List<SpecificationReadDto>, List<ProductSpecification>> {
    @Override
    public List<ProductSpecification> map(List<SpecificationReadDto> object) {
        return object.stream()
                .map(dto -> ProductSpecification.builder()
                        .specKey(dto.getSpecKey())
                        .specValue(dto.getSpecValue())
                        .build())
                .toList();

    }
}
