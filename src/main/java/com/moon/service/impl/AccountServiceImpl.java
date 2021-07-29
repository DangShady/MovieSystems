package com.moon.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.entity.Account;
import com.moon.entity.Authority;
import com.moon.entity.Role;
import com.moon.respository.AccountDAO;
import com.moon.respository.AuthorityDAO;
import com.moon.service.AccountService;
import com.moon.service.RoleService;


@Repository
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accDao;
	
	@Autowired
	AuthorityDAO authDao;
	
	@Autowired
	RoleService roleService;
	
	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return accDao.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		
		return accDao.findAllSortById();
	}

	@Override
	public Account create(Account account) {
		
		
		account.setActivated(true);
		account.setDateregister(new Date());
		
		accDao.save(account);
		
		Role role = roleService.findRoleByName("Guests");
		Authority auth = new Authority();
		auth.setAccount(account);
		auth.setRole(role);
		authDao.save(auth);	
		
		return account;
	}

	@Override
	public Account getCustomerDetail(String username) {
		
		return accDao.findById(username).get();
	}

	@Override
	public void createUser(@Valid Account account) {
		
		account.setActivated(true);
		account.setDateregister(new Date());
		
		accDao.save(account);
		
		Role role = roleService.findRoleByName("Users");
		Authority auth = new Authority();
		auth.setAccount(account);
		auth.setRole(role);
		
		authDao.save(auth);	
		
	}
}
