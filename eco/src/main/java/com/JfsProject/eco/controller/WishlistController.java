package com.JfsProject.eco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.dto.Wishlistdto;
import com.JfsProject.eco.model.Wishlist;
import com.JfsProject.eco.service.WishlistService;


@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
	@Autowired
    private WishlistService wishlistService;

	 @PostMapping("/add")
	    public Wishlist addToWishlist(@RequestBody Wishlistdto dto) {
	        return wishlistService.addToWishlist(dto.getUserId(), dto.getProductId());
	    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlist(@PathVariable Long userId) {

        return wishlistService.getWishlistByUser(userId);

    }

    @DeleteMapping("/remove/{wishlistId}")
    public String removeWishlist(@PathVariable Long wishlistId) {

        wishlistService.removeFromWishlist(wishlistId);

        return "Product Removed From Wishlist Successfully";

    }

}

