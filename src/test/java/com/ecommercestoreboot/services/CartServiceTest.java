package com.ecommercestoreboot.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommercestoreboot.model.Cart;
import com.ecommercestoreboot.model.Product;
import com.ecommercestoreboot.repository.CartRepository;
import com.ecommercestoreboot.service.CartService;
import com.ecommercestoreboot.service.impl.CartServiceImpl;



@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

	@Mock
	CartRepository repo;
	
	@InjectMocks
	CartServiceImpl cartService;
	
	
	@Test
	public void whenGetCartByIdIsCalledWithExistingCartItIsReturned() {
		//arrange
		Cart expectedCart = new Cart();
		//act
		when(repo.findById(1)).thenReturn(Optional.of(expectedCart));
		Cart actualCart = cartService.getCartById(1);
		//assert
		assertEquals(expectedCart, actualCart);
	}
}
