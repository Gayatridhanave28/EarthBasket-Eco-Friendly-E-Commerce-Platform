package com.JfsProject.eco.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews")
public class Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer rating;

    @Column(length = 1000)
    private String comment;
}
