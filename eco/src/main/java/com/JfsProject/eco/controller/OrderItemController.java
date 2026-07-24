package com.JfsProject.eco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.model.OrderItem;
import com.JfsProject.eco.service.OrderItemService;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {
	@Autowired
    private OrderItemService orderItemService;

    @GetMapping("/order/{orderId}")
    public List<OrderItem> getOrderItems(
            @PathVariable Long orderId) {

        return orderItemService.getItemsByOrder(orderId);

    }
}
