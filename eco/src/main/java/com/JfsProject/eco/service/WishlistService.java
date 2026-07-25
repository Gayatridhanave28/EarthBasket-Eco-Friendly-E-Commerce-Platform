package com.JfsProject.eco.service;

import java.util.List;

import com.JfsProject.eco.model.Wishlist;

public interface WishlistService {

	Wishlist addToWishlist(Long userId, Long productId);

    List<Wishlist> getWishlistByUser(Long userId);

    void removeFromWishlist(Long wishlistId);
}
