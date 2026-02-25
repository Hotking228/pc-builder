package com.hotking.pcbuilder.repository;

import com.hotking.pcbuilder.entity.Category;
import com.hotking.pcbuilder.entity.CategoryLimit;
import com.hotking.pcbuilder.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryLimitRepository extends JpaRepository<CategoryLimit, Long> {

    @Query("select c_l from CategoryLimit c_l " +
            "where c_l.sourceCategory.id = :CategoryId and c_l.targetProduct.id = :productId")
    public List<CategoryLimit> findAllByProductAndCategory(Long CategoryId, Long productId);
}
