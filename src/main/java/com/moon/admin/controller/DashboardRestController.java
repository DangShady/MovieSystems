package com.moon.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moon.entity.Order;
import com.moon.service.ReportService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/admin/dashboard")
public class DashboardRestController {

	
	@Autowired
	ReportService rpService;
	
	@GetMapping("topProduct")
	public Page<Object[]> getTopProductDashboard(){
		
		return rpService.topProductDashboard();
	}
	
	@GetMapping("recentOrder")
	public Page<Order> getRecentOrder(){
		
		return rpService.recentOrders();
	}
	
	@GetMapping("total")
	public Object[] getTotal() {
		
		return rpService.getTotalDashboard();
	}
}
