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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario{
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private String lastName;
    
    @Column
    private String birthdate;
    
    @Column
    private String emailAddress;
    
    @Column
    private String phone;
    
    @Column
    private String dniNumber;
    
    @Column
    private String street1;
    
    @Column
    private String city;
    
    @Column
    private String contry;
    
    @Column
    private String postalCode;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	private Set<Orden> ordenes = new HashSet<>();
    
    
    protected Usuario() {} 

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getDniNumber() {
		return dniNumber;
	}
	
	public void setDniNumber(String dniNumber) {
		this.dniNumber = dniNumber;
	}
	
	public String getStreet1() {
		return street1;
	}
	
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getContry() {
		return contry;
	}
	
	public void setContry(String contry) {
		this.contry = contry;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Orden> getOrdenes() {
		return ordenes;
	}
	
	public void setOrdenes(Set<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public Usuario(String name, String lastName, String birthdate, String emailAddress, String phone, String dniNumber,
			String street1, String city, String contry, String postalCode) {
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.dniNumber = dniNumber;
		this.street1 = street1;
		this.city = city;
		this.contry = contry;
		this.postalCode = postalCode;
	}
	
	public Usuario(String name, String lastName, String birthdate, String emailAddress, String phone, String dniNumber,
			String street1, String city, String contry, String postalCode, Set<Orden> ordenes) {
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.dniNumber = dniNumber;
		this.street1 = street1;
		this.city = city;
		this.contry = contry;
		this.postalCode = postalCode;
		this.ordenes = ordenes;
	}

	@Override
	public String toString() {
		String salida =  "Usuario [id=" + id + ", Name=" + name + ", LastName=" + lastName + ", birthdate=" + birthdate
				+ ", emailAddress=" + emailAddress + ", phone=" + phone + ", dniNumber=" + dniNumber + ", street1=" + street1 + ", city="
				+ city + ", contry=" + contry + ", postalCode=" + postalCode + "]; ";
		return salida;
	}

}
