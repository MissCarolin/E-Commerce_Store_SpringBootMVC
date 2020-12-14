package com.ecommercestoreboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


	@Entity
	public class Customer  {
		
		@Id
		@GeneratedValue
		@Column(name = "customer_id")
		private Integer Id;
		
//		@NotEmpty (message = "The customer name can not be null")
		private String customerName;
		
//		@NotEmpty (message = "The customer Email can not be null")
		private String customerEmail;
		private String customerPhone;
		
//		@NotEmpty (message = "The customer username can not be null")
		private String username;

//		@NotEmpty (message = "The customer name can not be null")
		public String password;
		
		private boolean enabled; 
		
		public Customer(String customerName) {
			super();
			this.customerName = customerName;
		}

		public Customer() {
			super();
		}

		@OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name="billingAddressId")
	    private BillingAddress billingAddress;

	    @OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name="shippingAddressId")
	    private ShippingAddress shippingAddress;

		@OneToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name = "cartId")
		private Cart cart;

		
		//getters + setters
		
	    public Integer getId() {
	    	return Id;
	    }
	    
	    public void setId(Integer id) {
	    	Id = id;
	    }

		public String getCustomerName() {
			return customerName;
		}


		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public String getCustomerPhone() {
			return customerPhone;
		}

		public void setCustomerPhone(String customerPhone) {
			this.customerPhone = customerPhone;
		}
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public BillingAddress getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(BillingAddress billingAddress) {
			this.billingAddress = billingAddress;
		}

		public ShippingAddress getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(ShippingAddress shippingAddress) {
			this.shippingAddress = shippingAddress;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}
		
	}

