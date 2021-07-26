package com.moon.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moon.entity.Order;
import com.moon.entity.OrderDetail;
import com.moon.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/admin/order")
public class OrderAdminController {

	@Autowired
	OrderService orderService;
	
	@GetMapping()
	public List<Order> getAll(){
		
		return orderService.getAll();
	}
	
	@GetMapping("{id}")
	public List<OrderDetail> getOrderDetail(@PathVariable("id") Integer id) {	
		return orderService.findById(id);
	}
	
}
