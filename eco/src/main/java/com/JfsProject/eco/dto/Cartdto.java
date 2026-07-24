package com.JfsProject.eco.dto;


import lombok.Data;


@Data
public class Cartdto {
	private Long cartId;

    private Long userId;

    private Long productId;

    private Integer quantity;
}
