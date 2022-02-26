package com.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.exceptions.ResourceNotFoundException;
import com.product.models.Product;
import com.product.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	private ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/product")
	private ResponseEntity<Product> getProduct(@RequestParam("id") int productId) {
		try {
			return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Prouduct not found for this id :: " + productId);
		}

	}

	@PostMapping("/product")
	private ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		productService.saveOrUpdateProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/product")
	private ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		try {
			productService.update(product, product.getId());
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error occured on update this prouduct");
		}

	}

	@DeleteMapping("/product")
	private ResponseEntity<HttpStatus> deleteProduct(@RequestParam("id") int productId) {
		try {
			productService.delete(productId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Prouduct not found for this id :: " + productId);
		}

	}
}
