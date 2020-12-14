package com.ecommercestoreboot.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercestoreboot.exception.ProductNotFoundException;
import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.repository.ProductRepository;
import com.ecommercestoreboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService { //inetrface between db and controller 

	@Autowired
	private ProductRepository productDao;  

	//	@Override
	public List<Product> getProductList() {
		return productDao.findAll();
	}

	@Override
	public void addProduct(Product product) {
		productDao.save(product);		
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> optProduct = productDao.findById(id);
		if(optProduct.isPresent())
			return optProduct.get();
		else
			throw new ProductNotFoundException(id);
	}

	@Override
	public void deleteProduct(Integer id) {
		Optional<Product> optProduct = productDao.findById(id);
		if (optProduct.isPresent()) 
			productDao.delete(optProduct.get());
	}

	@Override
	public void editProduct(Product product) {
		productDao.save(product);		
	}

	@Override
	public List<Product> findProductByProductCategory(String productCategory) {
		return productDao.findProductByProductCategory(productCategory);
	}

	@Override
	public List<Product> findProductByProductName(String productName) {
		return productDao.findProductByProductName(productName);
	}

}


