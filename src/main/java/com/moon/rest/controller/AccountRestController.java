package com.moon.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moon.entity.Account;
import com.moon.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	AccountService accService;
	
	@GetMapping("/userInLogin")
	public Account getAcc() {
		
		String username = request.getRemoteUser();
		
		if(username!= null) {
			return accService.findById(username);
		}
		
		return null;
	}
	
	@GetMapping("/test")
	public Account getAccTest() {

			return accService.findById("ngocthao");
	}
	
	
}
