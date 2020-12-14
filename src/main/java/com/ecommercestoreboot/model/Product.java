package com.ecommercestoreboot.model;


import javax.persistence.*;


@Entity
public class Product  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer id;
	
	//	@NotEmpty(message = "the product name can't be empty")
	private String productName;
	private String productCategory;
	private String productDescription;
	
//	@Min(value = 0, message = "The product price has to be higher than 0")
	private double productPrice;
	private String productStatus;
	
//	@Min(value = 0, message = "The product unit has to be higher than 0")
	private int unitStock;
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //in other class it's mapped by productField 
//	@JsonIgnore //not getting converted into Json to not create a loop
//	private List<CartItem> cartItemList	
	
	public Product() {
		super();
	}
	
	public Product(String productName, String productCategory) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;	
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getUnitStock() {
		return unitStock;
	}
	public void setUnitStock(int unitStock) {
		this.unitStock = unitStock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		return true;
	}

	

	

}
