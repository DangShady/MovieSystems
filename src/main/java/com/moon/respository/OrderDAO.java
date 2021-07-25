package com.moon.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moon.entity.Order;



@Repository
public interface OrderDAO extends JpaRepository<Order, Integer>{

	
	@Query("SELECT o FROM Order o WHERE o.account.username = ?1 ORDER BY o.id DESC")
	List<Order> findByUserName(String username);
	
}
