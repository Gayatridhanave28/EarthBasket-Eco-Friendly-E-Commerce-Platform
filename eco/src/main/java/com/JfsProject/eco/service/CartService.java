package com.JfsProject.eco.service;

import java.util.List;

import com.JfsProject.eco.dto.Cartdto;
import com.JfsProject.eco.model.Cart;

public interface CartService {
	Cart addToCart(Cartdto dto);

    List<Cart> getCartByUser(Long userId);

    void removeFromCart(Long cartId);
}
