package com.hotking.pcbuilder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "compatibility_rule")
public class CompatibilityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_category_id")
    private Category sourceCategory;

    @ManyToOne
    @JoinColumn(name = "target_category_id")
    private Category targetCategory;

    private String sourceSpecKey;

    private String targetSpecKey;

    @Enumerated(EnumType.STRING)
    private Operator operator;

    private String value;
}
