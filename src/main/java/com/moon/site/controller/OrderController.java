package com.moon.site.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	
	@RequestMapping("/order/checkout")
	public String checkout() {	
		
		return "/site/products/shopping-cart";
	}
	
	@RequestMapping("/order/list")
	public String listOrder(Model model, HttpServletRequest request) {
		
		String username = request.getRemoteUser();
		
		model.addAttribute("orders", orderService.findByUserName(username));
		
		return "/site/accounts/history";
	}
	
	@GetMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") int id,Model model) {
		
		model.addAttribute("details",orderService.findById(id));
		
		return "/site/accounts/history-product";
	}
}
