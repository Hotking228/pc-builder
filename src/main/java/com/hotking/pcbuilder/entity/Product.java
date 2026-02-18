package com.hotking.pcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String vendorCode;

    private Float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    private String manufacturer;

    @OneToMany(mappedBy = "product")
    private List<ProductSpecification> specifications;
}
