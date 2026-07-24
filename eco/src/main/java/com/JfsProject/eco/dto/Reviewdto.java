package com.JfsProject.eco.dto;
import lombok.Data;

@Data
public class Reviewdto {

	private Long reviewId;

    private Long userId;

    private Long productId;

    private Integer rating;

    private String comment;
}
