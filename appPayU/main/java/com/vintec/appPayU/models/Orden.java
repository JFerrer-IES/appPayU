package com.vintec.appPayU.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Producto> productos = new HashSet<>();

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
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	public Orden(String referencia, String firma, double total) {
		this.firma = firma;
		this.referencia = referencia;
		this.total = total;
	}
	
	public Orden(String referencia, String firma, double total, Usuario usuario, Set<Producto> productos) {
		this.firma = firma;
		this.referencia = referencia;
		this.total = total;
		this.usuario = usuario;
		this.productos = productos;
	}
	
	public Orden() {}
	
	@Override
	public String toString() {
		String salida = "Orden [id=" + id + ", referencia=" + referencia + ", firma=" + firma + ", total=" + total + "]; ";
		return salida;
    }
}