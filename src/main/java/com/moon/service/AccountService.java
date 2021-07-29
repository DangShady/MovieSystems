package com.moon.service;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.moon.entity.Account;


@Service
public interface AccountService {
	
	Account findById(String username);

	List<Account> findAll();

	Account create(Account account);

	Account getCustomerDetail(String username);

	void createUser(@Valid Account account);
	
}
