package com.ecommercestoreboot.controller;

import static org.mockito.Mockito.verify;
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
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@MockBean
	private CustomerService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testToGetLoginViewPWithshowLogin() throws Exception {
		mockMvc.perform(get("/login"))
		.andExpect(status().isOk())
		.andExpect(view().name("login"));
	}

	@Test
	public void testToGetLogoutViewPWithRemoveAttribute() throws Exception {
		mockMvc.perform(get("/logout"))
		.andExpect(status().isOk())
		.andExpect(view().name("logoutSuccess"));
	}
	
//	@Test
//	public void testloginAddsTheCorrectAttributeToModel() throws Exception {		
//		
//		mockMvc.perform(post("/login")
//				.param("username", "user"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("home"));
//
//				verify(service).getCustomerByUsername("user");
//	}
//	
	
	
}
