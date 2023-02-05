package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public List<Category> categoryList(){
		return categoryService.categoryList();
	}
	
	@PostMapping("/saveCategory")
	public ResponseEntity<String> addCategory(@RequestBody Category category){
		categoryService.categoryRegister(category);
		String mensaje = "Creacion exitosa";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		categoryService.deleteClient(id);
		return new ResponseEntity<>("Categoria Eliminado con exito", HttpStatus.OK);
	}
	
	@PutMapping("/updateCategory/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category category ){
	Optional<Category> updateCategory = categoryService.obtienePorId(id);
	
	if(updateCategory.isPresent()) {
		Category categ = updateCategory.get();
		categ.setNombre(category.getNombre());
		categ.setAbreviacion(category.getAbreviacion());
		
		return new ResponseEntity<>(categoryService.categoryRegister(categ), HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		
	}
}
