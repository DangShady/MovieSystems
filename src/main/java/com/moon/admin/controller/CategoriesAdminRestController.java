package com.moon.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moon.entity.Category;
import com.moon.entity.Product;
import com.moon.service.CategoryService;
import com.moon.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/admin/categories")
public class CategoriesAdminRestController {

	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping()
	public List<Category> getAll(){
		return categoryService.findAll();
	}
	
	@GetMapping("{id}")
	public Category getCategory(@PathVariable("id") Integer id) {
		
		return categoryService.getCateByUpdate(id);
	}
	
	@PostMapping()
	public Category create(@RequestBody Category category) {
		
		return categoryService.create(category);
	}
	
	@PutMapping("/{id}")
	public Category update(@PathVariable("id") Integer id,@RequestBody Category category) {
		
		return categoryService.update(category);
	}
	
}
