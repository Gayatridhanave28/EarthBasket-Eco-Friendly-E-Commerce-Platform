package com.JfsProject.eco.dto;

import java.time.LocalDate;


import lombok.Data;


@Data
public class Orderdto {
	 private Long orderId;

	    private Long userId;

	    private LocalDate orderDate;

	    private Double totalAmount;

	    private String status;
}
