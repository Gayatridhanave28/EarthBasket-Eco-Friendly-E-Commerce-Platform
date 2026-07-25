package com.JfsProject.eco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JfsProject.eco.model.Cart;
import com.JfsProject.eco.model.Product;
import com.JfsProject.eco.model.User;



@Repository
@Qualifier("cartRepo")
public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findByUser(User user);
    void deleteByProduct(Product product);

    Optional<Cart> findByUserAndProduct(User user, Product product);

}
