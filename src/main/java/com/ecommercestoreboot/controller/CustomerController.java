package com.ecommercestoreboot.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommercestoreboot.service.CustomerService;
import com.ecommercestoreboot.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;


	//SHOW LOGIN FORM
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	//SHOW LOGOUT FORM
	@GetMapping("/logout")
	public String showLogout(HttpSession session) {
		session.removeAttribute("sessioncustomer");
		return "logoutSuccess";
	}

	//LOGIN 
	@PostMapping("/login")
	public String login(HttpSession session, ModelMap model, @RequestParam String username, String password)  {
		Customer sessionCustomer = customerService.getCustomerByUsername(username);
		
		if(sessionCustomer.getUsername().equals(username) && (sessionCustomer.getPassword().equals(password))) {
			session.setAttribute("sessioncustomer", sessionCustomer);
			model.addAttribute("sessioncustomer", sessionCustomer); 

		return "home";
		}
		else 
			model.addAttribute("error", "wrong username and/or password"); //pass message instead of object
			return "login";
	}
	
}

	

