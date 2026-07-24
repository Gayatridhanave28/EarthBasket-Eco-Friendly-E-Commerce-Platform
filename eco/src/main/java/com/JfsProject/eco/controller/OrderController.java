package com.JfsProject.eco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.model.Order;
import com.JfsProject.eco.service.OrderService;

@RestController
@RequestMapping("/api/orders")

public class OrderController {
	
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {

        return orderService.placeOrder(order);

    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {

        return orderService.getOrdersByUser(userId);

    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();

    }

    @PutMapping("/status/{orderId}")
    public Order updateStatus(@PathVariable Long orderId,
                              @RequestParam String status) {

        return orderService.updateOrderStatus(orderId, status);

    }
    
    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {

        try {

            orderService.deleteOrder(orderId);

            return "Order Deleted";

        } catch (Exception e) {

            e.printStackTrace();

            return e.getMessage();

        }

    }

}
