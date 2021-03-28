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
@Table(name = "payment")

public class Payment {

	public Payment() {
		super();
	}
	
	@Column(name="payment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String paymentMode;
	private double amount;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date paymentDate;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_users_id")
 	private Users users;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_cartItems_id")
 	private CartItems cartItems;

	public Payment(String paymentMode, double amount, Date paymentDate) {
		super();
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	    public long getId() {
	    return id;
	}
	public void setId(long id) {
	    this.id = id;
	}

	@Column(name="payment_mode")
	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Column(name="amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name="payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	
	public CartItems getCartItems() {
		return cartItems;
	}

	public void setCartItems(CartItems cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentMode=" + paymentMode + ", amount=" + amount + ", paymentDate="
				+ paymentDate + "]";
	}
	
	
	
	
	
}
