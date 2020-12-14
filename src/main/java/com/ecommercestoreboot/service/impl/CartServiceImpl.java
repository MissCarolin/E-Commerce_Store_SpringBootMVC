package com.ecommercestoreboot.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercestoreboot.exception.CartNotFoundException;
import com.ecommercestoreboot.model.Cart;
import com.ecommercestoreboot.repository.CartRepository;
import com.ecommercestoreboot.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository repo;

	@Override
	public Cart getCartById(Integer id) {
		Optional<Cart> optCart = repo.findById(id);
		if(optCart.isPresent())
			return optCart.get();
		else
			throw new CartNotFoundException(id);
	}

}

