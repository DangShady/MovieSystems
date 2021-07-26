package com.moon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.entity.Role;
import com.moon.respository.RoleDAO;
import com.moon.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	RoleDAO roleDao;
	
	@Override
	public Role findRoleByName(String name) {
		
		return roleDao.findRoleByName(name);
	}

}
