package com.moon.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

	@RequestMapping("/account/profile")
	public String profile() {
		
		return "site/accounts/user-profile";
	}
	
	@RequestMapping("/account/change-password")
	public String changePassword() {
		
		return "site/accounts/password";
	}
}
