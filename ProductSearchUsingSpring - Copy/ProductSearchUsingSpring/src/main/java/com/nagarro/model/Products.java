package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Products {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private String id;
	@Column(name="NAME")
	String name;
	@Column(name="Color")
	String color;
	@Column(name="GENDER_RECOMMENDATION")
	String gender_rec;
	@Column(name="SIZE")
	String size;
	@Column(name="PRICE")
	String price;
	@Column(name="RATING")
	String rating;
	@Column(name="AVAILABILITY")
	String avalability;
	public Products() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGender_rec() {
		return gender_rec;
	}
	public void setGender_rec(String gender_rec) {
		this.gender_rec = gender_rec;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAvalability() {
		return avalability;
	}
	public void setAvalability(String avalability) {
		this.avalability = avalability;
	}
		
	


}
