package com.JfsProject.eco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.dto.Reviewdto;
import com.JfsProject.eco.exception.ResourceNotFoundException;
import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.model.Review;
import com.JfsProject.eco.model.User;
import com.JfsProject.eco.repository.ProductRepository;
import com.JfsProject.eco.repository.ReviewRepository;
import com.JfsProject.eco.repository.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
	public Review addReview(Reviewdto dto) {
		 User user = userRepository.findById(dto.getUserId())
	                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	        Product product = productRepository.findById(dto.getProductId())
	                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

	        Review review = new Review();
	        review.setUser(user);
	        review.setProduct(product);
	        review.setRating(dto.getRating());
	        review.setComment(dto.getComment());

	        return reviewRepository.save(review);
	}

	@Override
	public List<Review> getReviewsByProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return reviewRepository.findByProduct(product);
	}

	@Override
	public Double getAverageRating(Long productId) {

        Double avg = reviewRepository.getAverageRating(productId);

        return avg == null ? 0.0 : avg;
	}

}
