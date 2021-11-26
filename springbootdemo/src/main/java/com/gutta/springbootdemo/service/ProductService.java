package com.gutta.springbootdemo.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gutta.springbootdemo.model.Product;

@Service
public class ProductService {
	static Set<Product> products = new HashSet<Product>();

	ProductService() {
		products.add(new Product(101, "Laptop", 10000.00));
		products.add(new Product(102, "Mobile", 10000.00));
		products.add(new Product(103, "Tab", 10000.00));
	}

	public Set<Product> findAll() {
		return products;
	}

	public Product save(Product product) {
		products.add(product);
		return product;
	}
	
	public Product update(Product product) {
		products.remove(findById(product.getId()));
		products.add(product);
		return product;
	}

	public Product findById(long id) {
		return products.stream().filter(product -> product.getId() == id).collect(Collectors.toList()).get(0);
	}

	public Product deleteById(long id) {
		Product product = findById((long) id);
		products.remove(product);
		return product;
	}
}
