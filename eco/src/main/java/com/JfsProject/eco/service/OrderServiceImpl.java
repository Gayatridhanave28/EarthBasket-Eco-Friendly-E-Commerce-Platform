package com.JfsProject.eco.service;

import java.time.LocalDate;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.model.Cart;
import com.JfsProject.eco.model.Order;
import com.JfsProject.eco.model.User;
import com.JfsProject.eco.repository.CartRepository;
import com.JfsProject.eco.repository.OrderItemRepository;
import com.JfsProject.eco.repository.OrderRepository;
import com.JfsProject.eco.repository.UserRepository;
import com.JfsProject.eco.model.OrderItem;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
	
    @Override
    public Order placeOrder(Order order) {

        User user = userRepository.findById(order.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        List<Cart> cartItems = cartRepository.findByUser(user);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is Empty");
        }

        double total = 0;

        for (Cart cart : cartItems) {

            total += cart.getProduct().getPrice() * cart.getQuantity();

        }

        order.setUser(user);
        order.setOrderDate(LocalDate.now());
        order.setStatus("Pending");
        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);

        for (Cart cart : cartItems) {

            OrderItem item = new OrderItem();

            item.setOrder(savedOrder);

            item.setProduct(cart.getProduct());

            item.setQuantity(cart.getQuantity());

            item.setPrice(
                    cart.getProduct().getPrice() * cart.getQuantity()
            );

            orderItemRepository.save(item);

        }

        cartRepository.deleteAll(cartItems);

        return savedOrder;
    }

	@Override
	public List<Order> getOrdersByUser(Long userId) {
		 User user = userRepository.findById(userId).orElse(null);

	        return orderRepository.findByUser(user);
	}

	@Override
	public List<Order> getAllOrders() {
		 return orderRepository.findAll();
	}

	@Override
	public Order updateOrderStatus(Long orderId, String status) {
		Order order = orderRepository.findById(orderId).orElse(null);

        if (order != null) {

            order.setStatus(status);

            return orderRepository.save(order);

        }

        return null;
    }
	@Override
    @Transactional
    public void deleteOrder(Long orderId) {

        orderItemRepository.deleteByOrderOrderId(orderId);

        orderRepository.deleteById(orderId);
    }
	}


