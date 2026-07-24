package com.JfsProject.eco.service;

import java.util.List;

import com.JfsProject.eco.model.OrderItem;

public interface OrderItemService {
	 List<OrderItem> getItemsByOrder(Long orderId);
}
