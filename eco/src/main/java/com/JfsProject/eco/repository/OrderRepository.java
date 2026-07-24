package com.JfsProject.eco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JfsProject.eco.model.Order;
import com.JfsProject.eco.model.User;


@Repository
@Qualifier("orderRepo")
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
    @Query("SELECT COALESCE(SUM(o.totalAmount), 0) FROM Order o")
    Double getTotalRevenue();

}