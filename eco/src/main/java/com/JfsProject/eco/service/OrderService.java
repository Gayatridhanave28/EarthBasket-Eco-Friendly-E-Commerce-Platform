package com.JfsProject.eco.service;

import java.util.List;

import com.JfsProject.eco.model.Order;

public interface OrderService {
	Order placeOrder(Order order);

    List<Order> getOrdersByUser(Long userId);

    List<Order> getAllOrders();
    
    void deleteOrder(Long orderId);

    Order updateOrderStatus(Long orderId, String status);
}
