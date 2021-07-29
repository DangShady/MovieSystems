package com.moon.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.moon.entity.Product;


@Service
public interface ProductService {

	List<Product> findByCategoryId(int id);

	Product findByProductId(int id);

	List<Product> findAll();

	Product findOneProduct(int id);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	Page<Product> newProducts();
	
	
}
