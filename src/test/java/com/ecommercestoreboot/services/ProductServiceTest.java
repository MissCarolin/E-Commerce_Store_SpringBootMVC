package com.ecommercestoreboot.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommercestoreboot.exception.ProductNotFoundException;
import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.repository.ProductRepository;
import com.ecommercestoreboot.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@Mock
	ProductRepository repo;
	
	@InjectMocks
	ProductServiceImpl productService;
	
//	private Product product;
	
	@Test
	public void whenGetProductLististCalledGetProductListIsCalledOnRepository() {
		//act
		productService.getProductList();
		//verify
		verify(repo).findAll();
	}
	
	@Test
	public void whenAddProductIsCalledSaveIsCalledOnRepository() {
		//arrange
		Product expectedProduct = new Product("Lillys", "flowers");
		//act
		productService.addProduct(expectedProduct);
		//assert
		verify(repo).save(expectedProduct);
	}
	

	@Test
	public void whenGetProductByIdIsCalledWithExistingProductItIsReturned() {
		//arrange
		Product expectedProduct = new Product("Lillys", "flowers");
		//act
		when(repo.findById(1)).thenReturn(Optional.of(expectedProduct));
		Product actualProduct = productService.getProductById(1);
		//assert
		assertEquals(expectedProduct, actualProduct);
	}
	
	@Test
	public void whenFindProductByProductNameIsCalledFindProductByProductNameIsCalledOnRepository() {
		productService.findProductByProductCategory("flowers");
		//assert
		verify(repo).findProductByProductCategory("flowers");
	}
	
	@Test
	public void whenfindProductByProductNameIsCalledFindProductByProductNameIsCalledOnRepository() {
		productService.findProductByProductName("Basil");
		//assert
		verify(repo).findProductByProductName("Basil");
	}
	
	@Test
	public void whenEditProductIsCalledEditIsCalledOnRepository() {
		Product expectedProduct = new Product("Lillys", "flowers");
		//act
		productService.editProduct(expectedProduct);
		//verify
		verify(repo).save(expectedProduct);
	}
	
	@Test
	public void whenDeleteProductIsCalledDeleteIsCalledOnRepository() {
		Product expectedProduct = new Product("Lillys", "flowers");
		//act
		when(repo.findById(1)).thenReturn(Optional.of(expectedProduct));
		productService.deleteProduct(1);
		//verify
		verify(repo, times(1)).delete(expectedProduct);
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void whenGetProductByIdIsCalledWithNotExistingProductNotFoundExceptionIsThrown() {
		when(repo.findById(1)).thenReturn(Optional.empty());
		
		Product actualProduct = productService.getProductById(1);
	}

}
