package com.ibnselam.codingchallenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "Please provide a title")
	private String title;
	
	@NotEmpty(message = "Please provide a subtitle")
	private String subTitle;
	
	@NotNull(message = "Please provide a price")
	@Min((long) 1.00)
	private double price;
	
	@NotEmpty(message = "Please provide a description")
	private String description;
	
	@NotNull(message = "Please provide a rating")
	@Min((int) 1)
	private int rating;
	
	@NotEmpty(message = "Please provide an image")
	private String image;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String title, String subTitle, double price, String description, int rating, String image) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.price = price;
		this.description = description;
		this.rating = rating;
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public int getRating() {
		return rating;
	}
	public String getImage() {
		return image;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
