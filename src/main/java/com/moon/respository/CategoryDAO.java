package com.moon.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moon.entity.Category;



@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{

	@Query("SELECT c FROM Category c ORDER BY c.id DESC")
	List<Category> findAllOrderById();

	
}
