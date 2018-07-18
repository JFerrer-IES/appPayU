package com.vintec.appPayU.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class Merchant {
	private String apiLogin;
	private String apiKey;
	
	public String getApiLogin() {
		return apiLogin;
	}
	public void setApiLogin(String apiLogin) {
		this.apiLogin = apiLogin;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Merchant(String apiLogin, String apiKey) {
		super();
		this.apiLogin = apiLogin;
		this.apiKey = apiKey;
	}
	@Override
	public String toString() {
		return "\"merchant\": { \"apiLogin\":\""+apiLogin+"\",\"apiKey\":\""+apiKey+"\"},";
	}
	
}