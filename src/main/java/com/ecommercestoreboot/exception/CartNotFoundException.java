package com.ecommercestoreboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CartNotFoundException extends RuntimeException {
	
	public CartNotFoundException(Integer id) {
		super("The Cart with id: " + id + " was not found.");
	}

}
