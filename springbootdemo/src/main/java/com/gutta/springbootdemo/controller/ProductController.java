package com.gutta.springbootdemo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutta.springbootdemo.model.Product;
import com.gutta.springbootdemo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping // Type: GET, URL: http://localhost:8080/products
	public Set<Product> getProducts() {

		return productService.findAll();

	}

	@GetMapping("/{id}") // Type: GET, URL: http://localhost:8080/products/102
	public Product getProduct(@PathVariable Long id) {

		return productService.findById((long) id);

	}

	@PostMapping // Type: POST, URL: http://localhost:8080/products Body: { "id": 105,"name":
					// "iWatch", "price": 70000.0 }
	public ResponseEntity createProduct(@RequestBody Product product) throws URISyntaxException {

		Product savedProduct = productService.save(product);
		return ResponseEntity.created(new URI("/products/" + savedProduct.getId())).body(savedProduct);

	}
 
	@PutMapping("/{id}") // Type: PUT, URL: http://localhost:8080/products/105 Body: { "id": 105,"name":
							// "iWatch", "price": 90000.0 }
	public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {

		Product toupdateProduct = new Product((long) id, product.getName(), product.getPrice());
		Product updatedProduct = productService.save(product);

		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{id}") // Type: DELETE, URL: http://localhost:8080/products/105
	public ResponseEntity deleteProduct(@PathVariable Long id) {

		productService.deleteById((long) id);
		return ResponseEntity.ok().build();

	}
}
