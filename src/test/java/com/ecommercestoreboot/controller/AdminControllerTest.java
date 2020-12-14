package com.ecommercestoreboot.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {
	
	@MockBean
	private ProductService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testToGetAddProductFormWithAddProduct() throws Exception {
		mockMvc.perform(get("/admin/product/addProduct"))
		.andExpect(status().isOk())
		.andExpect(view().name("addProduct"));
	}
	
	@Test
	public void testToAddProductToProductListWithAddProductPost() throws Exception {
		//Arrange
		Product expectedProduct=new Product("Lillys", "flowers");
		//Act
		mockMvc.perform(post("/admin/product/addProduct")
		.param("productName", "Lillys").param("productCategory", "flowers"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/admin/productInventory"));
		//Assert 
		verify(service).addProduct(expectedProduct);
	}
	
	@Test
	public void testToGetEditProductFormWitheditProduct() throws Exception {
		mockMvc.perform(get("/admin/product/editProduct/1"))
		.andExpect(status().isOk())
		.andExpect(view().name("editProduct"));

		
	}
	
	@Test
	public void testToEditProductfromProductListWithEditProductPost() throws Exception {
		//Arrange
		//Act
		mockMvc.perform(post("/admin/product/editProduct")
		.param("productName", "Lillys").param("productCategory", "herbs"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/admin/productInventory"));
		//Assert 
	}
	
	@Test
	public void testToDeleteProductfromProductListWithdeleteProduct() throws Exception {
		//Arrange
		//Act
		mockMvc.perform(get("/admin/product/deleteProduct/5")
		.param("productName", "Lillys").param("productCategory", "flowers"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/admin/productInventory"));
		//Assert 
	}
	
}