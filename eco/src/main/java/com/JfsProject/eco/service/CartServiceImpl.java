package com.JfsProject.eco.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.model.Cart;
import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.model.User;
import com.JfsProject.eco.repository.CartRepository;
import com.JfsProject.eco.repository.ProductRepository;
import com.JfsProject.eco.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
    private CartRepository cartRepository;
	
	 @Autowired
	    private UserRepository userRepository;
	 
	 @Autowired
	    private ProductRepository productRepository;
	
	@Override
	public Cart addToCart(Cart cart) {
		User user = userRepository.findById(cart.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(cart.getProduct().getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.setUser(user);
        cart.setProduct(product);

        return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getCartByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepository.findByUser(user);
	}

	@Override
	public void removeFromCart(Long cartId) {

        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart Item Not Found");
        }

        cartRepository.deleteById(cartId);
		
	}

}
