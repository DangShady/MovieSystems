package com.moon.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.entity.Product;
import com.moon.respository.ProductDAO;
import com.moon.service.ProductService;


@Controller
public class HomeController {

	@Autowired
	ProductDAO proDao;
	
	@Autowired
	ProductService proService;
	
	
	@RequestMapping("/home")
	public String home() {
		return "/site/index";
	}
	
	@RequestMapping("/thank")
	public String thank() {
		return "/site/accounts/thankyou";
	}
	
	
	@ModelAttribute("newProducts")
	public Page<Product> newProduct(){
		
		Pageable page = PageRequest.of(0, 8);
		
		return proService.newProducts();
		
	}
	
}
