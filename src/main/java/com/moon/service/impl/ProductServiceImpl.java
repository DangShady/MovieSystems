package com.moon.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.moon.entity.Product;
import com.moon.respository.ProductDAO;
import com.moon.service.ProductService;


@Repository
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO proDao;
	
	@Override
	public List<Product> findByCategoryId(int id) {
		// TODO Auto-generated method stub
		return proDao.findByCategoryId(id);
	}

	@Override
	public Product findByProductId(int id) {
		// TODO Auto-generated method stub
		return proDao.findById(id).get();
	}


}
