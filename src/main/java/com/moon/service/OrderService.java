package com.moon.service;



import java.util.List;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.moon.entity.Order;

@Service
public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(int id);

	List<Order> findByUserName(String username);



}
