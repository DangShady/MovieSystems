package com.moon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	@Override
	public List<Role> findAll() {
		
		return roleDao.findAll();
	}

}
