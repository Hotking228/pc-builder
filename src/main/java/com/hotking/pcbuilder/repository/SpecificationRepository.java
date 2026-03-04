package com.hotking.pcbuilder.repository;

import com.hotking.pcbuilder.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {

    @Query(value = "SELECT " +
                "    p_s.spec_key, " +
                "    MAX(spec_value) " +
                "FROM product_specification p_s " +
                "JOIN product p ON p_s.product_id = p.id " +
                "JOIN product_category p_c ON p_c.id = p.category_id " +
                "WHERE slug = :slug " +
                "GROUP BY p_s.spec_key " +
                "ORDER BY p_s.spec_key",
            nativeQuery = true)
    List<String[]> findAllBySlug(String slug);
}
