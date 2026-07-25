package com.JfsProject.eco.service;

import java.util.List;

import com.JfsProject.eco.dto.Reviewdto;
import com.JfsProject.eco.model.Review;

public interface ReviewService {
	Review addReview(Reviewdto dto);

    List<Review> getReviewsByProduct(Long productId);

    Double getAverageRating(Long productId);
}
