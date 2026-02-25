package com.hotking.pcbuilder.repository;

import com.hotking.pcbuilder.entity.Category;
import com.hotking.pcbuilder.entity.CompatibilityRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompatibilityRepository extends JpaRepository<CompatibilityRule, Long> {

    @Query("select c from CompatibilityRule c where c.sourceCategory = :c1 and c.targetCategory = :c2")
    public List<CompatibilityRule> findAllByCategories(Category c1, Category c2);
}
