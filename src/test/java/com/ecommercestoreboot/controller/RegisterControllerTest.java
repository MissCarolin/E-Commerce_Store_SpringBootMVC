package com.ecommercestoreboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.ecommercestoreboot.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {
	
	@MockBean
	private CustomerService service;
	
	@Autowired
	private MockMvc mockMvc;

	
	@Test
	public void  testToGetRegisterFormwithRegisterPath()throws Exception {
		mockMvc.perform(get("/register"))
		.andExpect(status().isOk())
		.andExpect(view().name("registerCustomer"));
	}
	
	@Test
	public void testToAddCustomerWithRegisterCustomerPostMethod() throws Exception {
		
		mockMvc.perform(post("/register")
		.param("customerName", "admin"))
		.andExpect(status().isOk())
		.andExpect(view().name("registerCustomerSuccess"));
		
	}
}
