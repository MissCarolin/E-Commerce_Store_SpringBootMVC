package com.ecommercestoreboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommercestoreboot.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {

}
