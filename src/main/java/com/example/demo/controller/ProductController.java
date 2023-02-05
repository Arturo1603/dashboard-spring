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


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> productList(){
		return productService.productList();
	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		productService.productRegister(product);
		String mensaje="Creacion exitosa";
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> deleteEntity(@PathVariable int id){
		productService.deleteProduct(id);
		return new ResponseEntity<>("Cliente eliminado con exito", HttpStatus.OK);
	}
	 
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
		Optional<Product> updateProduct = productService.obtieneporId(id);
		
        if(updateProduct.isPresent()) {
        	Product prod = updateProduct.get();
        	prod.setNombre(product.getNombre());
        	prod.setColor(product.getColor());
        	prod.setFecha_compra(product.getFecha_compra());
        	prod.setPrecio_venta(product.getPrecio_venta());
        	prod.setPrecio_compra(product.getPrecio_compra());
        	prod.setStock(product.getStock());
        	prod.setCategory(product.getCategory());
        	
        	
        	
        	return new ResponseEntity<>(productService.productRegister(prod), HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
