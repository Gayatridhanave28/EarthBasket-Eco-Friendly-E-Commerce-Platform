package com.JfsProject.eco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.model.Review;
import com.JfsProject.eco.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	 @Autowired
	    private ReviewService reviewService;

	    @PostMapping("/add")
	    public Review addReview(@RequestBody Review review) {
	        return reviewService.addReview(review);
	    }

	    @GetMapping("/product/{productId}")
	    public List<Review> getReviews(@PathVariable Long productId) {
	        return reviewService.getReviewsByProduct(productId);
	    }

	    @GetMapping("/average/{productId}")
	    public Double getAverageRating(@PathVariable Long productId) {
	        return reviewService.getAverageRating(productId);
	    }
}
