package com.moon.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.moon.entity.Account;


@Service
public interface AccountService {
	
	Account findById(String username);
	
}
