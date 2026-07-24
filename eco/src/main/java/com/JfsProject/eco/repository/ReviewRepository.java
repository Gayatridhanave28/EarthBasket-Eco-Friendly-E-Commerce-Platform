package com.JfsProject.eco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByProduct(Product product);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.product.productId = :productId")
    Double getAverageRating(Long productId);
    
    void deleteByProduct(Product product);
}
