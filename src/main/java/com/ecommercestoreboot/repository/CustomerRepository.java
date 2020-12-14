package com.ecommercestoreboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommercestoreboot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Customer findByUsername(String username);
	
	public Customer findByPassword(String password);

}
