package com.JfsProject.eco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JfsProject.eco.model.Product;


@Repository
@Qualifier("productRepo")
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategoryIgnoreCase(String category);

	List<Product> findByProductNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String keyword1,
            String keyword2,
            String keyword3);

}
