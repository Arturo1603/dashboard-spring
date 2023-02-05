package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> categoryList() {
		return categoryRepository.findAll();
	}

	@Override
	public Category categoryRegister(Category obj) {
		return categoryRepository.save(obj);
	}

	@Override
	public Optional<Category> obtienePorId(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public void deleteClient(int id) {
		categoryRepository.deleteById(id);
	}

}
