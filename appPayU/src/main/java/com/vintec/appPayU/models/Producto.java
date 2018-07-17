package com.vintec.appPayU.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String price_product;
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orden_id")
	private Orden orden;

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
	
	public String getPrice_product() {
		return price_product;
	}
	
	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}
	
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	
	public void setPrice_product(String price_product) {
		this.price_product = price_product;
	}
	
	public Orden getOrden() {
		return orden;
	}
	
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	
	protected Producto() {}
	
	public Producto(String name_product, String description_product, String price_product) {
		this.name_product = name_product;
		this.description_product = description_product;
		this.price_product = price_product;
	}
	
	public Producto(String name_product, String description_product, String price_product, Orden orden) {
		this.name_product = name_product;
		this.description_product = description_product;
		this.price_product = price_product;
		this.orden = orden;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name_product + ", description=" + description_product + ", price=" + price_product + "]; ";
	}
	
}
