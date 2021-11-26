package com.gutta.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @EqualsAndHashCode
public class Product {
	
	private long id;
	@EqualsAndHashCode.Exclude private String name;
	@EqualsAndHashCode.Exclude private double price;
}
