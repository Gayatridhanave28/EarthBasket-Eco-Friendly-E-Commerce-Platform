package com.JfsProject.eco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.model.Order;
import com.JfsProject.eco.model.OrderItem;
import com.JfsProject.eco.repository.OrderItemRepository;
import com.JfsProject.eco.repository.OrderRepository;


@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getItemsByOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));

        return orderItemRepository.findByOrder(order);

    }
	}


