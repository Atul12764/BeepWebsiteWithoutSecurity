package com.checkbeep.model;
import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "discount")

public class Discount {
	
	public Discount() {
		super();
	}
	
	@Column(name="discount_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String fullName;
	private double discount;
	private String type;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateOfCreation;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date validTillDate;
	
	private int quantity;
	
	public Discount(String fullName, double discount, String type, Date dateOfCreation, Date validTillDate,
			int quantity) {
		super();
		this.fullName = fullName;
		this.discount = discount;
		this.type = type;
		this.dateOfCreation = dateOfCreation;
		this.validTillDate = validTillDate;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name="discount")
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="date_of_creation")
	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Column(name="valid_till_date")
	public Date getValidTillDate() {
		return validTillDate;
	}

	public void setValidTillDate(Date validTillDate) {
		this.validTillDate = validTillDate;
	}

	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", fullName=" + fullName + ", discount=" + discount + ", type=" + type
				+ ", dateOfCreation=" + dateOfCreation + ", validTillDate=" + validTillDate + ", quantity=" + quantity
				+ "]";
	}
	
	
	

}
