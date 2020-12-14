package com.ecommercestoreboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercestoreboot.exception.CustomerNotFoundException;
import com.ecommercestoreboot.exception.CustomerUsernameNotFoundException;
import com.ecommercestoreboot.model.Customer;
import com.ecommercestoreboot.repository.CustomerRepository;
import com.ecommercestoreboot.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public void addCustomer(Customer customer) {
		 customerDao.save(customer);
		
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> optCustomer = customerDao.findById(id);
		if(optCustomer.isPresent())
			return optCustomer.get();
		else
			throw new CustomerNotFoundException(id);
	}

	//@Override
//	public boolean checkUsernameAndPassword(String username, String password) {
//		if (customerDao.findByUsername(username).equals(username) && (customerDao.findByPassword(password).equals(password)) ||
//		   (customerDao.findByUsername(username).equals(username) && (customerDao.findByPassword(password).equals(password)))) {
//			  return true;  
//		   }
//		return false;
//	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Optional<Customer> optCustomer = Optional.of(customerDao.findByUsername(username));
		if(optCustomer.isPresent())
			return optCustomer.get();
		else
			throw new CustomerUsernameNotFoundException(username);
	}
	
}
