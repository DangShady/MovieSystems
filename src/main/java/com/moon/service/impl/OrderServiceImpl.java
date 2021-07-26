package com.moon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moon.entity.Order;
import com.moon.entity.OrderDetail;
import com.moon.respository.OrderDAO;
import com.moon.respository.OrderDetailDAO;
import com.moon.service.OrderService;




@Repository
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	OrderDetailDAO detailDao;
	
	
	@Override
	public Order create(JsonNode orderData) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		orderDao.save(order);
		
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		
		detailDao.saveAll(details);
		
		return order;
		
	}


	@Override
	public List<OrderDetail> findById(int id) {
		// TODO Auto-generated method stub
		return orderDao.findByOrderDetail(id);
	}


	@Override
	public List<Order> findByUserName(String username) {
		// TODO Auto-generated method stub
		return orderDao.findByUserName(username);
	}


	@Override
	public List<Order> getAll() {
		
		return orderDao.findAllByDate();
	}

}
