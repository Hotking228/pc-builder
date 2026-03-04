package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.dto.SpecificationReadDto;
import com.hotking.pcbuilder.mapper.FromDtoToSpecMapper;
import com.hotking.pcbuilder.mapper.FromSpecificationToReadDtoMapper;
import com.hotking.pcbuilder.parsers.VersionParser;
import com.hotking.pcbuilder.repository.SpecificationRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SpecificationService {

    private final SpecificationRepository specificationRepository;
    private final FromSpecificationToReadDtoMapper specMapper;
    private final FromDtoToSpecMapper dtoMapper;
    private final VersionParser versionParser;

    public List<SpecificationReadDto> findAll(){
        return specificationRepository.findAll().stream()
                .map(specMapper::map)
                .toList();
    }

    public Optional<SpecificationReadDto> findById(Long id){
        //TODO: добавить исключение
        return Optional.of(
                specificationRepository.findById(id)
                        .map(specMapper::map)
                        .orElseThrow()
        );
    }
    @Transactional
    public Optional<SpecificationReadDto> update(SpecificationReadDto spec, Long id){
        return specificationRepository.findById(id)
                .map(entity -> dtoMapper.map(spec, entity))
                .map(specificationRepository::saveAndFlush)
                .map(specMapper::map);
    }
    @Transactional
    public Optional<SpecificationReadDto> create(SpecificationReadDto spec){

        return Optional.of(specificationRepository.saveAndFlush(dtoMapper.map(spec)))
                .map(specMapper::map);
    }

    @Transactional
    public boolean deleteById(Long id){
        var entity = specificationRepository.findById(id);
        if(entity.isEmpty()) return false;
        specificationRepository.deleteById(id);
        return true;
    }

    public List<String> findAllBySlugToSort(String slug) {
        List<String[]> specs = specificationRepository.findAllBySlug(slug);
        specs.add(new String[]{"price", "0"});
        specs.add(new String[]{"name", "0"});
        return specs.stream()
                .filter(val -> {
                    try{
                        Long.parseLong(val[1]);
                    } catch (NumberFormatException e){
                        try {
                            Long.parseLong(versionParser.parse(val[1]));
                        } catch (NumberFormatException e2){
                            return false;
                        }

                        return true;
                    }

                    return true;
                })
                .map(val->val[0])
                .toList();
    }
}
