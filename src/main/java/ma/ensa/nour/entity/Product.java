package ma.ensa.nour.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import ma.ensa.nour.validation.PositivePrice;

@Entity(name = "app_product")
public class Product {

	@GeneratedValue
	@Id
	private int id;
	
	@Size(min=3,message="the product name length must be at least 3 chars")
	private String name;
	
	@PositivePrice(message="the product's price must be positive ")
	private double price;
	
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
