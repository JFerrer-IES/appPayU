package com.vintec.appPayU;

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
	private String name_product;
	private String description_product;
	private String price_product;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private Object object;

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
	
	protected Producto() {}
	
	public Producto(String name_product, String description_product, String price_product) {
		this.name_product = name_product;
		this.description_product = description_product;
		this.price_product = price_product;
	}
	
	@Override
	public String toString() {
		String salida = String.format("Product[id='%d', name='%s', description='%s', price='%s'], ", id, name_product, description_product, price_product);
//		if(customer != null) {
//				salida += customer.toString();
//		}
		return salida;
	}
	
}
