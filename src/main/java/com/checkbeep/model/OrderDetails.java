package com.checkbeep.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_details")

public class OrderDetails {
	
	public OrderDetails() {
		super();
	}
	
	@Column(name="order_details_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double productPrice;
	private int productQuantity;
	private double subtotal;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_orders_id")
 	private Orders orders;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_product_details_id")
 	private ProductDetails productDetails;

	public OrderDetails(double productPrice, int productQuantity, double subtotal, Orders orders) {
		super();
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.subtotal = subtotal;
		this.orders = orders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "product_price")
	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "product_quantity")
	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Column(name = "subtotal")
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "OrderDetails [productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", subtotal="
				+ subtotal + ", orders=" + orders + "]";
	}
	
	

}
