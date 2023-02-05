package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Product> productList() {
		return productRepository.findAll();
	}
	
	
	@Override
	public Product productRegister(Product obj) {
		Category data = obj.getCategory();
		Optional<Category> dataCategory  = categoryRepository.findById(data.getIdcategoria());
		obj.setSku(dataCategory.get().getNombre() + obj.getColor());
		return productRepository.save(obj);
	}

	@Override
	public Optional<Product> obtieneporId(int id) {
		return productRepository.findById(id);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
		
	}

}
