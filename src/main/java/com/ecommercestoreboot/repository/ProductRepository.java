package com.ecommercestoreboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommercestoreboot.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findProductByProductCategory(String productCategory);
	
	public List<Product> findProductByProductName(String productName);


}
