package com.JfsProject.eco.dto;

import lombok.Data;


@Data

public class Productdto {
	private Long productId;

    private String productName;

    private String description;

    private Double price;

    private Integer stock;

    private String category;

    private String imageUrl;
    
    private String ecoScore;

    private Boolean biodegradable;

    private Boolean recyclable;
}
