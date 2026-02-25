package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.entity.Category;
import com.hotking.pcbuilder.entity.CategoryLimit;
import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.repository.CategoryLimitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryLimitService {

    private final CategoryLimitRepository limitRepository;

    public List<CategoryLimit> findAllByCategoryAndProduct(Category category, Product product){
        return limitRepository.findAllByProductAndCategory(category.getId(), product.getId());
    }
}
