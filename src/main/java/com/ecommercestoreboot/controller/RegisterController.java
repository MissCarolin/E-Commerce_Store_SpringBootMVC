package com.ecommercestoreboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommercestoreboot.model.BillingAddress;
import com.ecommercestoreboot.model.Cart;
import com.ecommercestoreboot.model.Customer;
import com.ecommercestoreboot.model.ShippingAddress;
import com.ecommercestoreboot.service.CustomerService;


@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;

	//GET CUSTOMER REGISTER FORM
	@GetMapping("/register")
	public String registerCustomer(ModelMap model) {
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();

		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		return "registerCustomer";
	}
	

	//ADD CUSTOMER
	@PostMapping(value = "/register")
	public String registerCustomerPost(ModelMap model, @ModelAttribute("customer") Customer customer) {
		
		Cart cart = new Cart();
		customer.setEnabled(true);
		customer.setCart(cart);
		customerService.addCustomer(customer);
		return "registerCustomerSuccess";
	}
}