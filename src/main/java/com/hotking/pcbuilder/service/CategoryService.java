package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.dto.CategoryDto;
import com.hotking.pcbuilder.entity.Category;
import com.hotking.pcbuilder.mapper.FromCategoryToDtoMapper;
import com.hotking.pcbuilder.mapper.FromDtoToCategoryMapper;
import com.hotking.pcbuilder.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final FromCategoryToDtoMapper categoryMapper;
    private final FromDtoToCategoryMapper dtoMapper;

    @Transactional
    public Optional<CategoryDto> create(CategoryDto categoryDto){
        return Optional.ofNullable(
                categoryMapper.map(
                        categoryRepository.saveAndFlush(dtoMapper.map(categoryDto))
                )
        );
    }

    @Transactional
    public Optional<CategoryDto> update(CategoryDto category, Long id){
        return categoryRepository.findById(id)
                .map(entity -> dtoMapper.map(category, entity))
                .map(categoryRepository::saveAndFlush)
                .map(categoryMapper::map);

    }

    public List<CategoryDto> findAll(){
        return categoryRepository.findAll().stream()
                .map(categoryMapper::map)
                .toList();
    }

    public Optional<CategoryDto> findById(Long id){
        //TODO: добавить исключение
        return Optional.ofNullable(
                categoryMapper.map(
                        categoryRepository.findById(id).orElseThrow()
                )
        );
    }

    @Transactional
    public boolean deleteById(Long id){
        var entity = categoryRepository.findById(id);
        if(entity.isEmpty()) return false;
        categoryRepository.deleteById(id);
        return true;
    }

    public Category findBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }
}
