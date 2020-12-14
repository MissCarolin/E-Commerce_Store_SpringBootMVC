package com.ecommercestoreboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity 
public class CartItem {

	@Id
	@GeneratedValue
	@Column(name = "cartItem_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name= "cart_id") //in table CartItem with name cartId
	private Cart cart;
	
	@ManyToOne //many cart items can be one product 
	@JoinColumn(name= "product_id")
	private Product product;
	
	private int quantity;
	private double totalPrice;
	
	//getters+setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
