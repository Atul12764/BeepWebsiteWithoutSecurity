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
@Table(name = "orders")

public class Orders {
			
		public Orders() {
			super();
		}
		
		@Column(name="orders_id")
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
	    private int orderNo;
	    
	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	    private Date orderDate;
	    
	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	    private Date shippingDate;
	    
	    private String stageOfOrder;
	    private double totalAmount;
	    
	    private byte isDelivered;
	    private byte isPayment;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	 	@JoinColumn(name = "fk_users_id")
	 	private Users users;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	 	@JoinColumn(name = "fk_address_id")
	 	private Address address;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	 	@JoinColumn(name = "fk_discount_id")
	 	private Discount discount;
	    
	    
		public Orders(int orderNo, Date orderDate, Date shippingDate, String stageOfOrder, double totalAmount,
				byte isDelivered, byte isPayment) {
			super();
			this.orderNo = orderNo;
			this.orderDate = orderDate;
			this.shippingDate = shippingDate;
			this.stageOfOrder = stageOfOrder;
			this.totalAmount = totalAmount;
			this.isDelivered = isDelivered;
			this.isPayment = isPayment;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		@Column(name="oreder_no")
		public int getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(int orderNo) {
			this.orderNo = orderNo;
		}

		@Column(name="order_date")
		public Date getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}

		@Column(name="shipping_date")
		public Date getShippingDate() {
			return shippingDate;
		}

		public void setShippingDate(Date shippingDate) {
			this.shippingDate = shippingDate;
		}

		@Column(name="stage_of_order")
		public String getStageOfOrder() {
			return stageOfOrder;
		}

		public void setStageOfOrder(String stageOfOrder) {
			this.stageOfOrder = stageOfOrder;
		}

		@Column(name="total_amount")
		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		@Column(name="is_delivered")
		public byte getIsDelivered() {
			return isDelivered;
		}

		public void setIsDelivered(byte isDelivered) {
			this.isDelivered = isDelivered;
		}

		@Column(name="is_payment")
		public byte getIsPayment() {
			return isPayment;
		}

		public void setIsPayment(byte isPayment) {
			this.isPayment = isPayment;
		}
		
		

		public Users getUsers() {
			return users;
		}

		public void setUsers(Users users) {
			this.users = users;
		}
		
		

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		
		public Discount getDiscount() {
			return discount;
		}

		public void setDiscount(Discount discount) {
			this.discount = discount;
		}

		@Override
		public String toString() {
			return "Orders [id=" + id + ", orderNo=" + orderNo + ", orderDate=" + orderDate + ", shippingDate="
					+ shippingDate + ", stageOfOrder=" + stageOfOrder + ", totalAmount=" + totalAmount
					+ ", isDelivered=" + isDelivered + ", isPayment=" + isPayment + "]";
		}
	    
		
	    
	    

}
