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
    private String state;
    
    
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
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
			String street1, String city,String state ,String contry, String postalCode) {
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.dniNumber = dniNumber;
		this.street1 = street1;
		this.city = city;
		this.state=state;
		this.contry = contry;
		this.postalCode = postalCode;
	}
	
	public Usuario(String name, String lastName, String birthdate, String emailAddress, String phone, String dniNumber,
			String street1, String city, String contry,String state, String postalCode, Set<Orden> ordenes) {
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.dniNumber = dniNumber;
		this.street1 = street1;
		this.city = city;
		this.state=state;
		this.contry = contry;
		this.postalCode = postalCode;
		this.ordenes = ordenes;
	}
	public String toJasonShipping()
	{
		
		return "\"shippingAddress\": {\"street1\":\""+street1+"\",\"city\":\""+city+"\",\"state\": \""+state+"\",\"country\":\""+contry+"\",\"postalCode\":\""+postalCode+"\",\"phone\":\""+phone+"\"}";	
		//postalCode and phone
	}
	public String toJasonBuyer()
	{
		
		return "\"buyer\": {\"fullName\":\""+name+" "+lastName+"\",\"emailAddress\":\""+emailAddress+"\",\"contactPhone\":\""+phone+"\",\"dniNumber\":\""+dniNumber+"\",\"shippingAddress\": {\"street1\":\""+street1+"\",\"city\":\""+city+"\",\"country\":\""+contry+"\"}},";	
	}
	public String toJasonPayer()
	{
		
		return "\"payer\": {\"fullName\":\""+name+" "+lastName+"\",\"emailAddress\":\""+emailAddress+"\", \"birthdate\": \""+birthdate+"\",\"contactPhone\":\""+phone+"\",\"dniNumber\":\""+dniNumber+"\",\"billingAddress\": {\"street1\":\""+street1+"\",\"city\":\""+city+"\",\"country\":\""+contry+"\",\"postalCode\":\""+postalCode+"\"}},";	
	}

	@Override
	public String toString() {
		String salida =  "Usuario [id=" + id + ", Name=" + name + ", LastName=" + lastName + ", birthdate=" + birthdate
				+ ", emailAddress=" + emailAddress + ", phone=" + phone + ", dniNumber=" + dniNumber + ", street1=" + street1 + ", city="
				+ city + ", state=" + state + ", contry=" + contry + ", postalCode=" + postalCode + "]; ";
		return salida;
	}

}
