package com.moon.site.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moon.entity.Product;
import com.moon.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	ProductService proService;
	
	@GetMapping("/product/list")
	public String listProduct(Model model, @RequestParam("id") int id) {
		
		List<Product> products = proService.findByCategoryId(id);
		
		model.addAttribute("products",products);
		
		return "/site/products/product";
	}
	
	@GetMapping("/product/detail/{id}")
	public String productDetail(Model model, @PathVariable("id") int id) {
		
		Product productDetail = proService.findByProductId(id);
		
		model.addAttribute("productDetail",productDetail);
		
		return "/site/products/product-detail";
	}
	
	
}
