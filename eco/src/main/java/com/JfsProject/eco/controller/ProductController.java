package com.JfsProject.eco.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.service.ProductService;


@RestController
@RequestMapping("/api/products")

public class ProductController {
	  @Autowired
	    private ProductService productService;

	    @PostMapping("/add")
	    public Product addProduct(@RequestBody Product product) {
	        return productService.addProduct(product);
	    }

	    @PutMapping("/update/{id}")
	    public Product updateProduct(@PathVariable Long id,
	                                 @RequestBody Product product) {
	        return productService.updateProduct(id, product);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable Long id) {

	        productService.deleteProduct(id);

	        return "Product Deleted Successfully";
	    }

	    @GetMapping("/{id}")
	    public Product getProduct(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @GetMapping("/all")
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }
	    
	    @GetMapping("/search")
	    public List<Product> searchProducts(@RequestParam String keyword) {

	        return productService.searchProducts(keyword);

	    }
	    
	    @GetMapping("/category/{category}")
	    public List<Product> getProductsByCategory(@PathVariable String category) {

	        category = category.replace("-", " ");

	        if (category.equalsIgnoreCase("personal care")) {
	            category = "Personal Care";
	        } else if (category.equalsIgnoreCase("garden")) {
	            category = "Garden";
	        } else if (category.equalsIgnoreCase("storage")) {
	            category = "Storage";
	        } else if (category.equalsIgnoreCase("kitchen")) {
	            category = "Kitchen";
	        } else if (category.equalsIgnoreCase("cleaning")) {
            category = "Cleaning";
        }

	        return productService.getProductsByCategory(category);
	    }
}
