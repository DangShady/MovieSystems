package com.moon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.entity.Account;
import com.moon.entity.Authority;
import com.moon.respository.AccountDAO;
import com.moon.respository.AuthorityDAO;
import com.moon.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	AccountDAO accDao;
	
	@Autowired
	AuthorityDAO authDao;
	
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accDao.getAdministrators();
		return authDao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return authDao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		
		return authDao.save(auth);
	}

	@Override	
	public void deleteById(Integer id) {
		
		authDao.deleteByIdCode(id);		
	}

	@Override
	public Authority getAuthotiryByAcc(String username) {
		
		return authDao.getAuthorityByAcc(username);
	}

}
