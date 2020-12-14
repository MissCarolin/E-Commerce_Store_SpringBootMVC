package com.ecommercestoreboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerUsernameNotFoundException extends RuntimeException {
	
	public CustomerUsernameNotFoundException(String username) {
		super("The Customer with username: " + username + " was not found.");
	}
}
