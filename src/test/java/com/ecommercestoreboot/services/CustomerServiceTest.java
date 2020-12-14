package com.ecommercestoreboot.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommercestoreboot.exception.CustomerNotFoundException;
import com.ecommercestoreboot.exception.ProductNotFoundException;
import com.ecommercestoreboot.model.Customer;
import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.repository.CustomerRepository;
import com.ecommercestoreboot.repository.ProductRepository;
import com.ecommercestoreboot.service.CustomerService;
import com.ecommercestoreboot.service.impl.CustomerServiceImpl;
import com.ecommercestoreboot.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	
	@Mock
	CustomerRepository repo;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	
	@Test
	public void whengetAllCustomersistCalledGetAllCustomersIsCalledOnRepository() {
		//act
		customerService.getAllCustomers();
		//verify
		verify(repo).findAll();
	}
	
	@Test
	public void whenAddCustomerIsCalledSaveIsCalledOnRepository() {
		//arrange
		Customer expectedCustomer = new Customer("luca");
		//act
		customerService.addCustomer(expectedCustomer);
		//assert
		verify(repo).save(expectedCustomer);
	}
	
	@Test
	public void whengetCustomerByIdIsCalledWithExistingCustomerItIsReturned() {
		//arrange
		Customer expectedCustomer = new Customer("luca");
		//act
		when(repo.findById(1)).thenReturn(Optional.of(expectedCustomer));
		Customer actualCustomer = customerService.getCustomerById(1);
		//assert
		assertEquals(expectedCustomer, actualCustomer);
	}
	
	
	@Test
	public void whengetCustomerByUsernameIsCalledWithExistingCustomerItIsReturned() {
		//arrange
		Customer expectedCustomer = new Customer("user");
		//act
		when(repo.findByUsername("user")).thenReturn(expectedCustomer);
		Customer actualCustomer = customerService.getCustomerByUsername("user");
		//assert
		assertEquals(expectedCustomer, actualCustomer);
	}
	
	@Test(expected = CustomerNotFoundException.class)
	public void whenGetCustomerByIdIsCalledWithNotExistingCustomerNotFoundExceptionIsThrown() {
		when(repo.findById(1)).thenReturn(Optional.empty());
		
		Customer actualCustomer = customerService.getCustomerById(1);
	}
	
}
