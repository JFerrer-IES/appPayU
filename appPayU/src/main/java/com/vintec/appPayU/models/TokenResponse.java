package com.vintec.appPayU.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TokenResponse {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("error")
	private String error;
	
	@JsonProperty("creditCardToken")
	private CreditCardToken creditCardToken;

	public String getCode() {
		return code;
	}

	public String getError() {
		return error;
	}

	public CreditCardToken getCreditCardToken() {
		return creditCardToken;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public void setCreditCardToken(CreditCardToken creditCardToken) {
		this.creditCardToken = creditCardToken;
	}

	@JsonCreator
	public TokenResponse(@JsonProperty("code") String code, @JsonProperty("error") String error, @JsonProperty("creditCardToken") CreditCardToken creditCardToken) {
		this.code = code;
		this.error = error;
		this.creditCardToken = creditCardToken;
	}

	@Override
	public String toString() {
		return "TokenResponse {'code'=" + code + ", 'error'=" + error + ", 'creditCardToken'=" + creditCardToken.toTokenResponse() + "}";
	}
	
	
}
