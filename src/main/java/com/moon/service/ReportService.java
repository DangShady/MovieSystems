package com.moon.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.moon.entity.Order;
import com.moon.report.ReportTotalSale;

public interface ReportService {

	Page<Object[]> topProductDashboard();

	Page<Order> recentOrders();

	ReportTotalSale getTotalDashboard();

	Object getTotalLastMonth();

	Object getTotalLastWeek();

	Map<String,Integer> getCountForShop();


}
