package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.dto.ProductCreateEditDto;
import com.hotking.pcbuilder.dto.ProductReadDto;
import com.hotking.pcbuilder.mapper.FromCreateDtoToProductMapper;
import com.hotking.pcbuilder.mapper.FromProductToReadDtoMapper;
import com.hotking.pcbuilder.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    FromCreateDtoToProductMapper productCreateMapper;
    FromProductToReadDtoMapper productReadDtoMapper;

    @Transactional
    public Optional<ProductReadDto> create(ProductCreateEditDto product){
        return Optional.ofNullable(
                productReadDtoMapper.map(
                        productRepository.saveAndFlush(productCreateMapper.map(product))
                )
        );
    }

    @Transactional
    public Optional<ProductReadDto> update(ProductCreateEditDto product, Long id){
        return productRepository.findById(id)
                  .map(entity -> productCreateMapper.map(product, entity))
                  .map(productRepository::saveAndFlush)
                  .map(productReadDtoMapper::map);

    }

    public List<ProductReadDto> findAll(){
        return productRepository.findAll().stream()
                .map(entity -> productReadDtoMapper.map(entity))
                .toList();
    }

    public Optional<ProductReadDto> findById(Long id){
        return Optional.ofNullable(
                productReadDtoMapper.map(
                        productRepository.findById(id).orElseThrow()
                )
        );
    }

    @Transactional
    public boolean deleteById(Long id){
        var entity = productRepository.findById(id);
        if(entity.isEmpty()) return false;
        productRepository.deleteById(id);
        return true;
    }
}
