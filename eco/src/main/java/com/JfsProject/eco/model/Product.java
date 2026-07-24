package com.JfsProject.eco.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    @Column(length = 1000)
    private String description;

    private Double price;

    private Integer stock;

    private String category;

    private String imageUrl;
    
 // Eco Fields

    private String ecoScore;

    private Boolean biodegradable;

    private Boolean recyclable;

}
