package com.ecommercestoreboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommercestoreboot.model.Customer;
import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/admin")
	public String getAdminPage(HttpSession session, ModelMap model) {
		Customer sessionCustomer = (Customer)session.getAttribute("sessioncustomer");
		System.out.println(sessionCustomer);
		model.addAttribute("sessioncustomer", sessionCustomer); 
		return "admin";
	}

	// SEE INVENTORY LIST
	@GetMapping("admin/productInventory")
	public String getProductInventory(ModelMap model) {

		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productInventory";
	}

	//ADD PRODUCT 
	@GetMapping("/admin/product/addProduct") 
	public String addProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}

	@PostMapping(value="/admin/product/addProduct") 
	public String addProductPost(ModelMap model, @ModelAttribute("product") Product product) {
		productService.addProduct(product);
		model.addAttribute("products", productService.getProductList());
		return "redirect:/admin/productInventory";
	}
	
	//EDIT PRODUCT
	@GetMapping("/admin/product/editProduct/{id}") 
	public String editProduct(ModelMap model, @PathVariable Integer id) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "editProduct";
	}
	
	@PostMapping(value="/admin/product/editProduct") 
	public String editProductPost(ModelMap model, @ModelAttribute Product product) {
		productService.editProduct(product);
		model.addAttribute("products", productService.getProductList());
		return "redirect:/admin/productInventory";
	}
	
	
	//DELETE PRODUCT
	@GetMapping("/admin/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Integer id, ModelMap model)  {
		productService.deleteProduct(id);
		return "redirect:/admin/productInventory";
	}

}
