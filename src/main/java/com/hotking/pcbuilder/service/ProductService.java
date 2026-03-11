package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.dto.ProductCreateEditDto;
import com.hotking.pcbuilder.dto.ProductReadDto;
import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.entity.Specification;
import com.hotking.pcbuilder.mapper.FromCreateDtoToProductMapper;
import com.hotking.pcbuilder.mapper.FromProductToReadDtoMapper;
import com.hotking.pcbuilder.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final FromCreateDtoToProductMapper productCreateMapper;
    private final FromProductToReadDtoMapper productReadDtoMapper;

    @Transactional
    public void create(Product product){
        for (Map.Entry<String, Specification> e : product.getSpecifications().entrySet()) {
            e.getValue().setProduct(product);
        }
        productRepository.saveAndFlush(product);
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
                .map(productReadDtoMapper::map)
                .toList();
    }

    public Optional<ProductReadDto> findById(Long id){
        //TODO: добавить исключение
        return Optional.ofNullable(
                productReadDtoMapper.map(
                        productRepository.findById(id).orElseThrow()
                )
        );
    }

    public Product findByIdEntity(Long id){

        //TODO: добавить исключение
        return productRepository.findByIdWithAllDepends(id).orElseThrow();
    }

    @Transactional
    public boolean deleteById(Long id){
        var entity = productRepository.findById(id);
        if(entity.isEmpty()) return false;
        productRepository.deleteById(id);
        return true;
    }

    public List<Product> findAllBySlug(String slug){
        return productRepository.findAllBySlug(slug);
    }

    public List<String> findCompaniesBySlug(String slug) {
        return productRepository.findCompaniesBySlug(slug);
    }
}
