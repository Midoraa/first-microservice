package com.test.product_service.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "Product")
public class ProductEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double price;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
