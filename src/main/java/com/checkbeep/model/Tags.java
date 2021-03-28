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
@Table(name = "tags")


public class Tags {
	
	public Tags() {
		super();
	}
	
	@Column(name="tags_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String tagName;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "fk_product_id")
 	private Product product;

	public Tags(String tagName) {
		super();
		this.tagName = tagName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "tag_name")
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Tags [id=" + id + ", tagName=" + tagName + "]";
	}
	
	
	
	
	

}
