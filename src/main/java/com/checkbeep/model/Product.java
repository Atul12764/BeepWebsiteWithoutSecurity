package com.checkbeep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "product")


public class Product {
	
	public Product() {
		super();
	}
	
	@Column(name="product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String productName;
	private String productDescription;
	private double price;
	private int stockAvailable;
	private String image;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="fk_category_id")
    private Category category;
	
	public Product(String productName, String productDescription, double price, int stockAvailable, String image) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.stockAvailable = stockAvailable;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="product_name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name="product_description")
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name="price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name="stock_available")
	public int getStockAvailable() {
		return stockAvailable;
	}

	public void setStockAvailable(int stockAvailable) {
		this.stockAvailable = stockAvailable;
	}

	@Column(name="image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", price=" + price + ", stockAvailable=" + stockAvailable + ", image=" + image + "]";
	}
	
	
	
	

}
