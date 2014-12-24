package ma.ensa.nour.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity(name = "app_category")
public class Category {

	@GeneratedValue
	@Id
	private int id;
	
	@Size(min=3,message="the category name length must be at least 3 chars")
	private String name;
	
	
	@Size(min=5, message="the category description must be at least 5 chars")
	@Column(length=Integer.MAX_VALUE)
	private String description;
	
	
	@OneToMany(mappedBy="category", cascade=CascadeType.REMOVE)
	private List<Product> products;

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public String toString(){
		return this.getName();
	}
	
	

	
}
