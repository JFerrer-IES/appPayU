package com.vintec.appPayU.models;

public class CreditCardRequest {
	
	private String number;
	private String securityCode;
	private String expirationDate;
	private String name;
	private String paymentMethod;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public CreditCardRequest(String number, String securityCode, String expirationDate, String name, String paymentMethod) {
		super();
		this.number = number;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
		this.name = name;
		this.paymentMethod=paymentMethod;
	}
	
	public String toJsonCreditCard()
	{
		return "\"creditCard\": {\"number\": \""+number+"\",\"securityCode\": \""+securityCode+"\",\"expirationDate\": \""+expirationDate+"\",\"name\": \""+name+"\" },";
	}
	
	

}
