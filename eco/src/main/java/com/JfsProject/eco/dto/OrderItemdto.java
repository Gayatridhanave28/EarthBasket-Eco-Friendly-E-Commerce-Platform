package com.JfsProject.eco.dto;
import lombok.Data;

@Data
public class OrderItemdto {
	private Long orderItemId;

    private Long orderId;

    private Long productId;

    private Integer quantity;

    private Double price;
}
