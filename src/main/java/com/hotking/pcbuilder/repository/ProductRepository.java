package com.hotking.pcbuilder.repository;

import com.hotking.pcbuilder.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join p.category c where c.slug = :slug")
    public List<Product> findAllBySlug(String slug);

    @Query("select p from Product p " +
            "left join fetch p.category " +
            "left join fetch p.specifications " +
            "where p.id = :id")
    public Optional<Product> findByIdWithAllDepends(Long id);

}
