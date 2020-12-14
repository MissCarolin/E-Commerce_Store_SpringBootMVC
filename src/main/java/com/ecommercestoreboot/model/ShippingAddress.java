package com.ecommercestoreboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddress {

	@Id
	@GeneratedValue
	@Column(name = "shippingAdress_id")
	private int id;
	private String streetName;
	private String apartmentNumber;
	private String zipCode;
	private String city;
	private String country;
	
	@OneToOne
    @JoinColumn(name="customer_Id")
	private Customer customer;

	//getters + setters
	public String getStreetName() {
		return streetName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ShippingAddress [streetName=" + streetName + ", apartmentNumber=" + apartmentNumber + ", zipCode="
				+ zipCode + ", city=" + city + ", country=" + country + ", customer=" + customer + "]";
	}

	

}
