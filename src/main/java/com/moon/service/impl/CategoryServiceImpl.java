package com.moon.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.moon.entity.Category;
import com.moon.entity.Product;
import com.moon.respository.CategoryDAO;
import com.moon.service.CategoryService;


@Repository
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO cateDao;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAllOrderById();
	}

	@Override
	public Category create(Category category) {
		
		return cateDao.save(category);
	}

	@Override
	public Category update(Category category) {
		return cateDao.save(category);
	}

	@Override
	public Category getCateByUpdate(Integer id) {
		
		return cateDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		
		cateDao.deleteById(id);
		
	}
	
}
