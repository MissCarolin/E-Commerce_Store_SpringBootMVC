package com.ecommercestoreboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.service.ProductService;


@Controller
public class ProductController { 

	@Autowired
	private ProductService productService; 
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//READ PRODUCT LIST
	@GetMapping(value = "/product/productList")
	public String getProducts(ModelMap model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productList";
	}
	
	//GET A SINGLE PRODUCT
	@GetMapping("/product/viewProduct/{id}")
	public String viewProduct(ModelMap model, @PathVariable Integer id) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}
	
	//Find Products by Category Herbs or Flowers
	@PostMapping("/filtered/category")
	public String findProductByCategory(ModelMap model, @RequestParam String productCategory) {
		model.addAttribute("products", productService.findProductByProductCategory(productCategory));
		return"productList";
	}
	
	//Find Products by Name
		@PostMapping("/filtered/name")
		public String findProductByName(ModelMap model, @RequestParam String productName) {
			model.addAttribute("products", productService.findProductByProductName(productName));
			return"productList";
		}
}

