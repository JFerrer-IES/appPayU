package com.vintec.appPayU.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name_product;
	
	@Column
	private String description_product;
	
	@Column
	private double price_product;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription_product() {
		return description_product;
	}
	
	public String getName_product() {
		return name_product;
	}
	
	public double getPrice_product() {
		return price_product;
	}
	
	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}
	
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	
	public void setPrice_product(double price_product) {
		this.price_product = price_product;
	}
	
	protected Producto() {}
	
	public Producto(String name_product, String description_product, double price_product) {
		this.name_product = name_product;
		this.description_product = description_product;
		this.price_product = price_product;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name_product + ", description=" + description_product + ", price=" + price_product + "]; ";
	}
	
}
