package com.moon.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAdminController {

	
	@RequestMapping({"/admin","/admin/home"})
	public String admin() {
		
		return "redirect:/admin/assets/layout-admin.html";
	}
}
