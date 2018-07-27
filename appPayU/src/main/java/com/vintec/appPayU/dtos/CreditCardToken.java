package com.vintec.appPayU.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CreditCardToken {

	@JsonProperty("creditCardTokenId")
	private String creditCardTokenId = "";
	
	@JsonProperty("name")
	private String name = "";
	
	@JsonProperty("payerId")
	private String payerId = "";
	
	@JsonProperty("identificationNumber")
	private String identificationNumber = "";
	
	@JsonProperty("paymentMethod")
	private String paymentMethod = "";
	
	@JsonProperty("number")
	private String number = "";
	
	@JsonProperty("expirationDate")
	private String expirationDate = "";
	
	@JsonProperty("creationDate")
	private String creationDate = "";
	
	@JsonProperty("maskedNumber")
	private String maskedNumber = "";
	
	@JsonProperty("errorDescription")
	private String errorDescription = "";

	public String getCreditCardTokenId() {
		return creditCardTokenId;
	}

	public String getName() {
		return name;
	}

	public String getPayerId() {
		return payerId;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public String getNumber() {
		return number;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getMaskedNumber() {
		return maskedNumber;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setCreditCardTokenId(String creditCardTokenId) {
		this.creditCardTokenId = creditCardTokenId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public void setMaskedNumber(String maskedNumber) {
		this.maskedNumber = maskedNumber;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	public CreditCardToken() {}

	public CreditCardToken(String payerId, String name, String identificationNumber, String paymentMethod, String number, String expirationDate) {
		this.payerId = payerId;
		this.name = name;
		this.identificationNumber = identificationNumber;
		this.paymentMethod = paymentMethod;
		this.number = number;
		this.expirationDate = expirationDate;
	}

	@JsonCreator
	public CreditCardToken(@JsonProperty("creditCardTokenId") String creditCardTokenId, @JsonProperty("name") String name, @JsonProperty("payerId") String payerId, @JsonProperty("identificationNumber") String identificationNumber, 
			@JsonProperty("paymentMethod") String paymentMethod, @JsonProperty("number") String number, @JsonProperty("expirationDate") String expirationDate, @JsonProperty("creationDate") String creationDate, 
			@JsonProperty("maskedNumber") String maskedNumber, @JsonProperty("errorDescription") String errorDescription) {
		this.creditCardTokenId = creditCardTokenId;
		this.name = name;
		this.payerId = payerId;
		this.identificationNumber = identificationNumber;
		this.paymentMethod = paymentMethod;
		this.number = number;
		this.expirationDate = expirationDate;
		this.creationDate = creationDate;
		this.maskedNumber = maskedNumber;
		this.errorDescription = errorDescription;
	}

	public String toTokenResponse() {
		return "{\"creditCardTokenId\": \"" + creditCardTokenId + "\", \"name\": \"" + name + "\", \"payerId\": \"" + payerId
				+ "\", \"identificationNumber\": \"" + identificationNumber + "\", \"paymentMethod\": \"" + paymentMethod + "\", \"number\": \""
				+ number + "\", \"expirationDate\": \"" + expirationDate + "\", \"creationDate\": \"" + creationDate + "\", \"maskedNumber\": \""
				+ maskedNumber + "\", \"errorDescription\": \"" + errorDescription + "\"}";
	}
	
	public String toTokenRequest() {
		return "{\"payerId\": \"" + payerId + "\", \"name\": \"" + name + "\", \"identificationNumber\": \"" 
				+ identificationNumber + "\", \"paymentMethod\": \"" + paymentMethod + "\", \"number\": \""
				+ number + "\", \"expirationDate\": \"" + expirationDate + "\"}";
	}
}
