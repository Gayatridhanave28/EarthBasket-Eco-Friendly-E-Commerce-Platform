package com.JfsProject.eco.service;

import java.util.List;

import com.JfsProject.eco.model.Product;

public interface ProductService {
	

	    Product addProduct(Product product);

	    Product updateProduct(Long productId, Product product);

	    void deleteProduct(Long productId);

	    Product getProductById(Long productId);

	    List<Product> getAllProducts();
	    
	    List<Product> searchProducts(String keyword);

	    List<Product> getProductsByCategory(String category);


	
}
