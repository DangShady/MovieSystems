package com.moon.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moon.entity.Account;
import com.moon.service.AccountService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/admin/customer")
public class CustomersAdminRestController {

	
	@Autowired
	AccountService acccountService;
	
	
	@GetMapping()
	public List<Account> getAll(){
		return acccountService.findAll();
	}
	
	@GetMapping("{username}")
	public Account getCategory(@PathVariable("username") String username) {
		
		return acccountService.getCustomerDetail(username);
	}
	
	@PostMapping()
	public Account create(@RequestBody Account account) {
		
		return acccountService.create(account);
	}
//	
//	@PutMapping("/{id}")
//	public Account update(@PathVariable("id") Integer id,@RequestBody Category category) {
//		
//		return categoryService.update(category);
//	}
//	
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable("id") Integer id) {		
//		categoryService.delete(id);
//	}
	
}
