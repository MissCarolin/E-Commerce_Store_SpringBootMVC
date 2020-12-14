package com.ecommercestoreboot.service;

import java.util.List;

import com.ecommercestoreboot.model.Customer;


public interface CustomerService {

	List<Customer> getAllCustomers();

	void addCustomer(Customer customer);
	
	Customer getCustomerById(Integer id);
	
	Customer getCustomerByUsername(String username);
	
	
	
	
}
