package com.hotking.pcbuilder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "port")
@EqualsAndHashCode(exclude = {"product"})
@ToString(exclude = {"product"})
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    private String portName;

    @Column(name = "portnum")
    private Integer portNum;
}
