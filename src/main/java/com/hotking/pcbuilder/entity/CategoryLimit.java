package com.hotking.pcbuilder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_limit")
public class CategoryLimit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category sourceCategory;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product targetProduct;

    private Integer maxCount;

    private String specKey;
}
