package com.checkbeep.model;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "cart_items")


public class CartItems {
	
	public CartItems() {
		super();
	}
	@Column(name="cart_items_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String saved;
	private int quantity;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addedDate;
	
	private String purchased;
	
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_users_id")
 	private Users users;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_product_id")
 	private Product product;
    

	public CartItems(String saved, int quantity, Date addedDate, String purchased) {
		super();
		this.saved = saved;
		this.quantity = quantity;
		this.addedDate = addedDate;
		this.purchased = purchased;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="saved")
	public String getSaved() {
		return saved;
	}

	public void setSaved(String saved) {
		this.saved = saved;
	}

	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="added_date")
	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Column(name="purchased")
	public String getPurchased() {
		return purchased;
	}

	public void setPurchased(String purchased) {
		this.purchased = purchased;
	}
	
	

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartItems [id=" + id + ", saved=" + saved + ", quantity=" + quantity + ", addedDate=" + addedDate
				+ ", purchased=" + purchased + "]";
	}
	
	
	
	
	
	
	

}
