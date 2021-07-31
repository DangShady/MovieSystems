package com.moon.service;

import java.util.List;

import javax.transaction.Transactional;

import com.moon.entity.Authority;

public interface AuthorityService {

	List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority auth);

	public void deleteById(Integer id);

	Authority getAuthotiryByAcc(String username);


}
