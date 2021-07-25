package com.moon.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {

	@GetMapping("/shoping-cart-view")
	public String viewCart() {
		
		return "/site/products/shopping-cart";
	}
	
	@GetMapping("/thank-buy")
	public String thank() {
		return "/site/products/thank-buy";
	}
	
}
