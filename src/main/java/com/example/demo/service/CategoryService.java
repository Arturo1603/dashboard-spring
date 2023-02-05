package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Category;

public interface CategoryService {
	
	public List<Category> categoryList();
	public Category categoryRegister(Category obj);
	Optional<Category> obtienePorId(int id);
	void deleteClient(int id);
}
