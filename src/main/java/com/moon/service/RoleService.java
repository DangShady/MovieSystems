package com.moon.service;

import java.util.List;

import com.moon.entity.Role;

public interface RoleService {

	Role findRoleByName(String name);

	List<Role> findAll();
}
