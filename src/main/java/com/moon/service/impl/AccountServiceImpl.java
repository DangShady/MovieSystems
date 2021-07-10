package com.moon.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.entity.Account;
import com.moon.respository.AccountDAO;
import com.moon.service.AccountService;


@Repository
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accDao;
	
	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return accDao.findById(username).get();
	}
}
