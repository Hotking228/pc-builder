package com.hotking.pcbuilder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product_category")
@ToString(exclude = {"products"})
@EqualsAndHashCode(exclude = {"products"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    @Column(length = 5000)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
