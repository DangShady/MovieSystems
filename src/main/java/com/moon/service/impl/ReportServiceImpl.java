package com.moon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moon.entity.Order;
import com.moon.report.ReportTotalSale;
import com.moon.respository.AccountDAO;
import com.moon.respository.CategoryDAO;
import com.moon.respository.OrderDAO;
import com.moon.respository.OrderDetailDAO;
import com.moon.respository.ProductDAO;
import com.moon.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	
	@Autowired
	OrderDetailDAO detailDao;
	
	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	AccountDAO accDao;
	
	@Autowired
	ProductDAO proDao;
	
	@Autowired
	CategoryDAO cateDao;
	
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
	public ReportTotalSale getTotalDashboard() {
		
		return detailDao.revenueByDashboardTotalSales();
	}

	@Override
	public Object getTotalLastMonth() {
		
		return detailDao.revenueByDashboardByMonth();
	}

	@Override
	public Object getTotalLastWeek() {
		
		return detailDao.revenueByDashboardByWeek();
	}

	@Override
	public Map<String,Integer> getCountForShop() {
		
		Map<String,Integer> items = new HashMap<>();
		
		int order = (int) orderDao.count();
		int account = (int) accDao.count();
		int product = (int) proDao.count();
		int category = (int) cateDao.count();
		
		items.put("order",order);
		items.put("account",account);
		items.put("product",product);
		items.put("category",category);
		
		return items;
	}

}
