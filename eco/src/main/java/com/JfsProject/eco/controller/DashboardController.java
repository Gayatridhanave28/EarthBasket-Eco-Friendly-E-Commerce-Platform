package com.JfsProject.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.dto.Dashboarddto;
import com.JfsProject.eco.service.DashboardService;

@RestController
@RequestMapping("/api/admin")
public class DashboardController {
	@Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public Dashboarddto getDashboard() {

        return dashboardService.getDashboardStatistics();
}
}
