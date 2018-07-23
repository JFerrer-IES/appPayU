package com.vintec.appPayU.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class MerchantRequest {
	private String apiLogin = "pRRXKOl8ikMmt9u";
	private String apiKey = "4Vj8eK4rloUd272L48hsrarnUA";
	
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
	
	public MerchantRequest() {}
	
	public MerchantRequest(String apiLogin, String apiKey) {
		super();
		this.apiLogin = apiLogin;
		this.apiKey = apiKey;
	}
	@Override
	public String toString() {
		return "\"merchant\": {\"apiKey\":\""+apiKey+"\", \"apiLogin\":\""+apiLogin+"\"},";
	}
	
}