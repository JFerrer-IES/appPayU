package com.vintec.appPayU.models;

public class Merchant {

	public String apiLogin = "pRRXKOl8ikMmt9u";
	
	public String apiKey = "4Vj8eK4rloUd272L48hsrarnUA";

	public String getApiLogin() {
		return apiLogin;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiLogin(String apiLogin) {
		this.apiLogin = apiLogin;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public Merchant() {}

	public Merchant(String apiLogin, String apiKey) {
		this.apiLogin = apiLogin;
		this.apiKey = apiKey;
	}

	@Override
	public String toString() {
		return "{\"apiLogin\": \"" + apiLogin + "\", \"apiKey\": \"" + apiKey + "\"}";
	}
	
}
