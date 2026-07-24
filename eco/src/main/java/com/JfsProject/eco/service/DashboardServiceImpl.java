package com.JfsProject.eco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JfsProject.eco.dto.Dashboarddto;
import com.JfsProject.eco.repository.OrderRepository;
import com.JfsProject.eco.repository.ProductRepository;
import com.JfsProject.eco.repository.UserRepository;

@Service
public class DashboardServiceImpl implements DashboardService {
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private OrderRepository orderRepository;

		@Override
		public Dashboarddto getDashboardStatistics() {

	        Dashboarddto dashboard = new Dashboarddto();

	        dashboard.setTotalUsers(userRepository.count());

	        dashboard.setTotalProducts(productRepository.count());

	        dashboard.setTotalOrders(orderRepository.count());

	        Double revenue = orderRepository.getTotalRevenue();

	        dashboard.setTotalRevenue(revenue == null ? 0.0 : revenue);

	        return dashboard;
		}

}

