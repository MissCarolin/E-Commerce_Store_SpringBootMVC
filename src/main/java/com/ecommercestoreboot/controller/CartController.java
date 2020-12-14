package com.ecommercestoreboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.ecommercestoreboot.model.Customer;
import com.ecommercestoreboot.service.CustomerService;
import com.ecommercestoreboot.service.ProductService;


@Controller
public class CartController {
	

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customer/cart") 
	public String getCart(HttpSession session, @ModelAttribute Customer customer) {//person that logged into system 
		Customer currentCustomer = (Customer)session.getAttribute("sessioncustomer");
		
		customerService.getCustomerByUsername(currentCustomer.getUsername()); 
		int cartId = currentCustomer.getCart().getId(); 
		return "redirect:/customer/cart/"+cartId;
	}
	
	@GetMapping("/customer/cart/{cartId}")
    public String getCartRedirect(@PathVariable int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
	
	
	//hack to put something in card 
//	@GetMapping("/product/cart/{id}")
//	public String addToCard(ModelMap model, @PathVariable Integer id){
//		Product product = productService.getProductById(id);
//		model.addAttribute("product", product);
//		return("cart"); 
//	}
}
