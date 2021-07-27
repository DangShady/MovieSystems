package com.moon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moon.entity.Order;
import com.moon.respository.OrderDAO;
import com.moon.respository.OrderDetailDAO;
import com.moon.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	
	@Autowired
	OrderDetailDAO detailDao;
	
	@Autowired
	OrderDAO orderDao;
	
	@Override
	public Page<Object[]> topProductDashboard() {
		
		PageRequest page = PageRequest.of(0, 8);
		
		return detailDao.topProductDashboard(page);
	}

	@Override
	public Page<Order> recentOrders() {
		PageRequest page = PageRequest.of(0, 8);
		
		return orderDao.getRecentOrders(page);
	}

	@Override
	public Object[] getTotalDashboard() {
		
		return detailDao.revenueByDashboardTotalSales();
	}

}
