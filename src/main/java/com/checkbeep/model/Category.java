package com.checkbeep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "category")

public class Category {

	public Category() {
		super();
	}
	
	@Column(name="catgory_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String categoryName;
	private String categoryImage;
	private String categoryDescription;
	public Category(String categoryName, String categoryImage, String categoryDescription) {
		super();
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
		this.categoryDescription = categoryDescription;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="category_name")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Column(name="category_image")
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	
	@Column(name="category_description")
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", categoryImage=" + categoryImage
				+ ", categoryDescription=" + categoryDescription + "]";
	}
	
	
	
	
	
}
