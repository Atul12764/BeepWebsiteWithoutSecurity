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
@Table(name = "product_details")


public class ProductDetails {
	
	public ProductDetails() {
		super();
	}
	
	@Column(name="product_details_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int size;
	private String colour;
	private byte Gender;
	private String ageGroup;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_prouct_id")
 	private Product product;

	public ProductDetails(int size, String colour, byte gender, String ageGroup) {
		super();
		this.size = size;
		this.colour = colour;
		Gender = gender;
		this.ageGroup = ageGroup;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="size")
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Column(name="colour")
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Column(name="gender")
	public byte getGender() {
		return Gender;
	}

	public void setGender(byte gender) {
		Gender = gender;
	}

	@Column(name="age_group")
	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
