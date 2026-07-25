package com.JfsProject.eco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.model.User;
import com.JfsProject.eco.model.Wishlist;
import com.JfsProject.eco.repository.ProductRepository;
import com.JfsProject.eco.repository.UserRepository;
import com.JfsProject.eco.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService{
	  @Autowired
	    private WishlistRepository wishlistRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ProductRepository productRepository;
	    public Wishlist addToWishlist(Long userId, Long productId) {
			User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User Not Found"));
	        Product product = productRepository.findById(productId)
	                .orElseThrow(() -> new RuntimeException("Product Not Found"));
	        if (wishlistRepository.findByUserAndProduct(user, product).isPresent()) {
	            throw new RuntimeException("Product already exists in wishlist");
	        }
	        Wishlist wishlist = new Wishlist();
	        wishlist.setUser(user);
	        wishlist.setProduct(product);
	        return wishlistRepository.save(wishlist);
		}

	@Override
	public List<Wishlist> getWishlistByUser(Long userId) {
		User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return wishlistRepository.findByUser(user);
	}

	@Override
	public void removeFromWishlist(Long wishlistId) {

        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RuntimeException("Wishlist Item Not Found");
        }

        wishlistRepository.deleteById(wishlistId);
    }
		
	}


