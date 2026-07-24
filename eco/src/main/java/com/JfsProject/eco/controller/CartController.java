package com.JfsProject.eco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.model.Cart;
import com.JfsProject.eco.service.CartService;

@RestController
@RequestMapping("/api/cart")

public class CartController {
	 @Autowired
	    private CartService cartService;

	    @PostMapping("/add")
	    public Cart addToCart(@RequestBody Cart cart) {

	        return cartService.addToCart(cart);

	    }

	    @GetMapping("/{userId}")
	    public List<Cart> getCart(@PathVariable Long userId) {

	        return cartService.getCartByUser(userId);

	    }

	    @DeleteMapping("/remove/{cartId}")
	    public String removeItem(@PathVariable Long cartId) {

	        cartService.removeFromCart(cartId);

	        return "Item Removed Successfully";

	    }
}
