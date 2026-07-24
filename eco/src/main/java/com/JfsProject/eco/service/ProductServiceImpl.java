 package com.JfsProject.eco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.repository.CartRepository;
import com.JfsProject.eco.repository.OrderItemRepository;
import com.JfsProject.eco.repository.ProductRepository;
import com.JfsProject.eco.repository.ReviewRepository;
import com.JfsProject.eco.repository.WishlistRepository;

import jakarta.transaction.Transactional;


@Service
public class ProductServiceImpl implements ProductService{

	 @Autowired
	    private ProductRepository productRepository;
	 
	 @Autowired
	 private CartRepository cartRepository;

	 @Autowired
	 private WishlistRepository wishlistRepository;

	 @Autowired
	 private ReviewRepository reviewRepository;

	 @Autowired
	 private OrderItemRepository orderItemRepository;

	
	
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long productId, Product product) {
		Product p = productRepository.findById(productId).orElse(null);

        if (p != null) {

            p.setProductName(product.getProductName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setStock(product.getStock());
            p.setCategory(product.getCategory());
            p.setImageUrl(product.getImageUrl());
            
            // Eco Fields

            p.setEcoScore(product.getEcoScore());
            p.setBiodegradable(product.getBiodegradable());
            p.setRecyclable(product.getRecyclable());

            return productRepository.save(p);
        }

        return null;
	}

	@Transactional
	@Override
	public void deleteProduct(Long id) {

	    Product product = productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    cartRepository.deleteByProduct(product);

	    wishlistRepository.deleteByProduct(product);

	    reviewRepository.deleteByProduct(product);

	    orderItemRepository.deleteByProduct(product);

	    productRepository.delete(product);
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	
	@Override
	public List<Product> searchProducts(String keyword) {

	    return productRepository
	            .findByProductNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(
	                    keyword,
	                    keyword,
	                    keyword);

	}

	@Override
	public List<Product> getProductsByCategory(String category) {

	    return productRepository.findByCategoryIgnoreCase(category);

	}

}
