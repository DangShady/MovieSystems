package com.moon.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moon.entity.Product;


@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE p.category.id =?1")
	List<Product> findByCategoryId(int id);

	@Query("SELECT p FROM Product p ORDER BY p.id DESC")
	List<Product> findAllByProductDate();
	
	
}
