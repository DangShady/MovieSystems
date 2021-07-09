package com.moon.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moon.entity.Authority;
import com.moon.entity.Product;


@Repository
public interface AuthorityDAO extends JpaRepository<Authority, Integer>{
	
	
}