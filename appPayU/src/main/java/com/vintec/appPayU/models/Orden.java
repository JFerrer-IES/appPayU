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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ordenes")
public class Orden {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column
	private String referencia;
	
	@Column
	private String firma;
	
	@Column
	private double total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producto_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Producto producto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Orden(String referencia, String firma, double total) {
		this.firma = firma;
		this.referencia = referencia;
		this.total = total;
	}
	
	public Orden(String referencia, String firma, double total, Producto producto) {
		this.firma = firma;
		this.referencia = referencia;
		this.total = total;
		this.producto = producto;
	}
	
	public Orden() {}
	
	@Override
	public String toString() {
		String salida = "Orden [id=" + id + ", referencia=" + referencia + ", firma=" + firma + ", total=" + total + "]; ";
		if(producto != null) {
			salida += producto.toString();
		}
		return salida;
    }
}
