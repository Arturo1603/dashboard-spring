package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface ProductService {
	
	public List<Product> productList();
	public Product productRegister(Product obj);
	Optional<Product> obtieneporId(int id);
	void deleteProduct(int id);

}
