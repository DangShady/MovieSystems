package com.moon.site.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moon.entity.Account;
import com.moon.respository.AccountDAO;
import com.moon.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountDAO accDao;
	
	@Autowired
	AccountService accService;
	
	@Autowired
	HttpServletRequest request;
	
	
	
	
	@RequestMapping("/account/change-password")
	public String changePassword() {
		
		return "site/accounts/password";
	}
	
	@RequestMapping("/security/register")
	public String register(Account account) {
		
		return "site/accounts/register";
	}

	
	@PostMapping("/security/register")
	public String regiter(@Valid Account account,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "site/accounts/register";
		}
		
		Optional<Account> ac = accDao.findById(account.getUsername());
		System.out.println("USERNAME: " + account.getUsername());
		
		
		if(!ac.isEmpty()) {
			model.addAttribute("message","Tài khoản đã tồn tại");	
		}
		else {
			this.accService.createUser(account);
			
			return "redirect:/thank";
		}
		
		return "site/accounts/register";
	}
	
	@GetMapping("/account/profile")
	public String viewProfile(Account account,Model model) {
		
		String username = request.getRemoteUser();
		
		account = accService.findById(username);
		
		model.addAttribute("account", account);
		
		return "site/accounts/user-profile";
	}
	
	
	@PostMapping("/account/profile")
	public String changeProfile(@Valid Account account,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return "site/accounts/user-profile";
		}
		try {			
			accDao.save(account);
			model.addAttribute("message","Thay đổi thông tin thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "site/accounts/user-profile";
	}
	
	@PostMapping("/account/change-password")
	public String changePassword(
			@RequestParam("password") String password,
			@RequestParam("newpass") String newpass,
			@RequestParam("confirmpass") String confirmpass,
			Model model
			) {
		
		
		String username = request.getRemoteUser();
		Account account = accService.findById(username);
		
		if(!newpass.equals(confirmpass)) {
			model.addAttribute("message","Xác nhận mật khẩu sai");
		}
		else if(!password.equals(account.getPassword())){
			model.addAttribute("message","Mật khẩu hiện tại không đúng");
		}
		else {
			account.setPassword(newpass);
			accDao.save(account);
			model.addAttribute("message","Đổi mật khẩu thành công");
		}
		return "site/accounts/password";
	}
}
