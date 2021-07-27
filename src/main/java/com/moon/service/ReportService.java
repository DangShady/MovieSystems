package com.moon.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.moon.entity.Order;

public interface ReportService {

	Page<Object[]> topProductDashboard();

	Page<Order> recentOrders();

	Object[] getTotalDashboard();

}
