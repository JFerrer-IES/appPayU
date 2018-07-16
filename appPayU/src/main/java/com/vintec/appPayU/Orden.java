package com.vintec.appPayU;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
	
	public Orden(String referencia, String firma, double total) {
		this.firma = firma;
		this.referencia = referencia;
		this.total = total;
	}
	
	public Orden() {}
	
	@Override
	public String toString() {
		return "Orden [id=" + id + ", referencia=" + referencia + ", firma=" + firma + ", total=" + total
                + "]";
    }
}
