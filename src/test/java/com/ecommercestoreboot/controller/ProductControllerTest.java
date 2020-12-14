package com.ecommercestoreboot.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.repository.ProductRepository;
import com.ecommercestoreboot.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)

public class ProductControllerTest {

	@MockBean
	private ProductService service;
	private ProductRepository repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testViewProductAddsTheCorrectAttributeToModel() throws Exception {
		
		Product product = new Product();
		
		List<Product> expectedproducts = new ArrayList<Product>();
		expectedproducts.add(0, product);
		
		Mockito.when(service.getProductList()).thenReturn(expectedproducts);
		mockMvc.perform(get("/product/productList"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("products", expectedproducts))
		.andExpect(view().name("productList"));
	}
	
	
	@Test
	public void testGetProductsAddsTheCorrectAttributesToModel() throws Exception {
		Product expectedProduct = new Product("Lillys", "flowers");
		when(service.getProductById(1)).thenReturn(expectedProduct);
		
		mockMvc.perform(get("/product/viewProduct/1"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("product", expectedProduct))
			.andExpect(view().name("viewProduct"));
	}
	
	
	@Test
	public void testfindProductByCategoryAddsTheCorrectAttributeToModel() throws Exception {		
		
		mockMvc.perform(post("/filtered/category")
				.param("productName", "Lillys").param("productCategory", "flowers"))
				.andExpect(status().isOk())
				.andExpect(view().name("productList"));

				verify(service).findProductByProductCategory("flowers");
	}
	
	@Test
	public void testfindProductByNameAddsTheCorrectAttributeToModel() throws Exception {
		
		mockMvc.perform(post("/filtered/name")
				.param("productName", "Lillys").param("productCategory", "flowers"))
				.andExpect(status().isOk())
				.andExpect(view().name("productList"));

				verify(service).findProductByProductName("Lillys");
	}
	
	
}
