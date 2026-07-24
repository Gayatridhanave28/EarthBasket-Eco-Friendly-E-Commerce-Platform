package com.JfsProject.eco.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.model.User;
import com.JfsProject.eco.model.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByUser(User user);
    
    void deleteByProduct(Product product);

    Optional<Wishlist> findByUserAndProduct(User user, Product product);

}
