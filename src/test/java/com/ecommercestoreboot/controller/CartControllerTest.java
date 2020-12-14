package com.ecommercestoreboot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ecommercestoreboot.model.Cart;
import com.ecommercestoreboot.model.Customer;
import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.service.CartService;
import com.ecommercestoreboot.service.CustomerService;
import com.ecommercestoreboot.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {

	@MockBean
	private CustomerService customerservice;
	
	@MockBean
	private CartService service;
	
	@Autowired
	private MockMvc mockMvc;
	
//	@Test
//	public void testToGetCartViewWithgetCartandId() throws Exception {
//		
//		Cart cart = new Cart();
//		Integer cartId = cart.getId();
//		
//		mockMvc.perform(get("/customer/cart"))
//		.andExpect(status().is3xxRedirection())
//		.andExpect(view().name("redirect:/customer/cart/cartId"));
//	}
	
	@Test
	public void testToGetCartandIdWithViewgetCartRedirect() throws Exception {
		
		mockMvc.perform(get("/customer/cart/8"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("cartId", 8))
		.andExpect(view().name("cart"));
	}
	
	
}
