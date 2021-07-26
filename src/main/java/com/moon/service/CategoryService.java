package com.moon.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.moon.entity.Category;
import com.moon.entity.Product;


@Service
public interface CategoryService{
	
	List<Category> findAll();

	Category create(Category category);

	Category update(Category product);

	Category getCateByUpdate(Integer id);

	void delete(Integer id);
}
