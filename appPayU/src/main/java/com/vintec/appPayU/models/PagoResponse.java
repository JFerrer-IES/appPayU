package com.vintec.appPayU.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PagoResponse {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("error")
	private String error;
	
	@JsonProperty("transactionResponse")
	private TransactionResponse transactionResponse;
	
	public String getCode() {
		return code;
	}
	
	public String getError() {
		return error;
	}
	
	public TransactionResponse getTransactionResponse() {
		return transactionResponse;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setTransactionResponse(TransactionResponse transactionResponse) {
		this.transactionResponse = transactionResponse;
	}
	
	public PagoResponse(@JsonProperty("code") String code, @JsonProperty("error") String error, @JsonProperty("transactionResponse") TransactionResponse transactionResponse) {
		this.code = code;
		this.error = error;
		this.transactionResponse = transactionResponse;
	}
	
	@Override
	public String toString() {
		return "PagoResponse {'code':" +code+ " 'error:'" +error+ " 'transactionResponse: {'" +transactionResponse.toString()+ "}"; 
	}
}
