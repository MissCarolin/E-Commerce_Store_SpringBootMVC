package com.ecommercestoreboot.service;

import java.util.List;

import com.ecommercestoreboot.model.Product;


public interface ProductService {

	List<Product> getProductList(); 
	
	void addProduct(Product product); 

	Product getProductById(Integer id); 
		
	void deleteProduct(Integer id); 

	void editProduct(Product product);
	
	public List<Product> findProductByProductCategory(String productCategory);
	
	public List<Product> findProductByProductName(String productName);

	
}
