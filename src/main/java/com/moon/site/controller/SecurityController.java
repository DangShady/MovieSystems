package com.moon.site.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.entity.Account;
import com.moon.respository.AccountDAO;

@Controller
public class SecurityController {

	
	@Autowired
	AccountDAO accDao;
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "/site/accounts/login";
	}
	
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		
		return "redirect:/home";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		
		model.addAttribute("message", "Đăng nhập thất bại: Sai thông tin đăng nhập");
		return "/site/accounts/login";
	}
	
	@RequestMapping("/security/login/unauthoried")
	public String unauthoried(Model model) {
		
		model.addAttribute("message", "Không có quyền truy xuất");
		return "/site/accounts/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoff(Model model) {
		
//		model.addAttribute("message", "Không có quyền truy xuất");
		return "redirect:/home";
	}
	
}
