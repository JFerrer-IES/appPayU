package com.vintec.appPayU;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String birthdate;
    private String emailAddress;
    private String phone;
    private String dniNumber;
    private String street1;
    private String city;
    private String contry;
    private String postalCode;
    
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", Name=" + name + ", LastName=" + lastName + ", birthdate=" + birthdate
				+ ", emailAddress=" + emailAddress + ", phone=" + phone + ", dniNumber=" + dniNumber + ", street1=" + street1 + ", city="
				+ city + ", contry=" + contry + ", postalCode=" + postalCode + "]";
	}

	

}
