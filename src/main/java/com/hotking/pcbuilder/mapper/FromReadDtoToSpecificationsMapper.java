package com.hotking.pcbuilder.mapper;

import com.hotking.pcbuilder.dto.SpecificationReadDto;
import com.hotking.pcbuilder.entity.Specification;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FromReadDtoToSpecificationsMapper implements Mapper<List<SpecificationReadDto>, Map<String, Specification>> {
    @Override
    public Map<String, Specification> map(List<SpecificationReadDto> object) {
        Map<String, Specification> map = new HashMap<>();
        for(int i= 0; i < object.size(); i++){
            map.put(object.get(i).getSpecKey(), Specification.builder()
                    .specKey(object.get(i).getSpecKey())
                    .specValue(object.get(i).getSpecValue())
                    .build());
        }


        return map;

    }
}
