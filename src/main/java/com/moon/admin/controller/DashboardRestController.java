package com.moon.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moon.entity.Order;
import com.moon.report.ReportTotalSale;
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
	public ReportTotalSale getTotal() {
		
		return rpService.getTotalDashboard();
	}
	
	@GetMapping("lastmonth")
	public Object getTotalLastMonth() {
		
		return rpService.getTotalLastMonth();
	}
	
	@GetMapping("lastweek")
	public Object getTotalLastWeek() {
		
		return rpService.getTotalLastWeek();
	}
	
	@GetMapping("count")
	public Map<String,Integer> getCountForShop() {
		
		return rpService.getCountForShop();
	}
}
