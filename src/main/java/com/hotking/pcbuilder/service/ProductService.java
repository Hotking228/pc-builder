package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.dto.ProductCreateEditDto;
import com.hotking.pcbuilder.dto.ProductReadDto;
import com.hotking.pcbuilder.mapper.FromCreateProductDtoToProductMapper;
import com.hotking.pcbuilder.mapper.FromProductToProductReadDtoMapper;
import com.hotking.pcbuilder.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    FromCreateProductDtoToProductMapper productCreateMapper;
    FromProductToProductReadDtoMapper productReadDtoMapper;

    public Optional<ProductReadDto> create(ProductCreateEditDto product){
        return Optional.ofNullable(
                productReadDtoMapper.map(
                        productRepository.save(productCreateMapper.map(product))
                )
        );
    }
}
