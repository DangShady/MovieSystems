package com.moon.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moon.entity.Category;


@Service
public interface CategoryService{
	
	List<Category> findAll();
}
