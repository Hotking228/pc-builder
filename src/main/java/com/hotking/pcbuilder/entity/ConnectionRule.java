package com.hotking.pcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "connection_rule")
public class ConnectionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "source_category_id")
    @ManyToOne
    private Category sourceCategory;

    @JoinColumn(name = "target_category_id")
    @ManyToOne
    private Category targetCategory;

    private String portName;
}
