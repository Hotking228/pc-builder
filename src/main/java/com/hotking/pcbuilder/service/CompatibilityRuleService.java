package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.dto.CategoryDto;
import com.hotking.pcbuilder.dto.CompatibilityDto;
import com.hotking.pcbuilder.mapper.FromCompatibiltyToDtoMapper;
import com.hotking.pcbuilder.mapper.FromDtoToCompatibilityMapper;
import com.hotking.pcbuilder.repository.CompatibilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompatibilityRuleService {

    private final FromCompatibiltyToDtoMapper compatibilityMapper;
    private final FromDtoToCompatibilityMapper dtoMapper;
    private final CompatibilityRepository compatibilityRepository;

    @Transactional
    public Optional<CompatibilityDto> create(CompatibilityDto compatibilityDto){
        return Optional.ofNullable(
                compatibilityMapper.map(
                        compatibilityRepository.saveAndFlush(dtoMapper.map(compatibilityDto))
                )
        );
    }

    @Transactional
    public Optional<CompatibilityDto> update(CompatibilityDto compatibility, Long id){
        return compatibilityRepository.findById(id)
                .map(entity -> dtoMapper.map(compatibility, entity))
                .map(compatibilityRepository::saveAndFlush)
                .map(compatibilityMapper::map);

    }

    public List<CompatibilityDto> findAll(){
        return compatibilityRepository.findAll().stream()
                .map(compatibilityMapper::map)
                .toList();
    }

    public Optional<CompatibilityDto> findById(Long id){
        //TODO: добавить исключение
        return Optional.ofNullable(
                compatibilityMapper.map(
                        compatibilityRepository.findById(id).orElseThrow()
                )
        );
    }

    @Transactional
    public boolean deleteById(Long id){
        var entity = compatibilityRepository.findById(id);
        if(entity.isEmpty()) return false;
        compatibilityRepository.deleteById(id);
        return true;
    }
}
