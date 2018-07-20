package com.vintec.appPayU.models;

public class TokenRequest {

	public String language = "es";
	
	public String command = "CREATE_TOKEN";
	
	public Merchant merchant = null;
	
	public CreditCardToken creditCardToken = null;

	public String getLanguage() {
		return language;
	}

	public String getCommand() {
		return command;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public CreditCardToken getCreditCardToken() {
		return creditCardToken;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public void setCreditCardToken(CreditCardToken creditCardToken) {
		this.creditCardToken = creditCardToken;
	}

	public TokenRequest(Merchant merchant, CreditCardToken creditCardToken) {
		this.merchant = merchant;
		this.creditCardToken = creditCardToken;
	}
	
	public TokenRequest(String language, String command, Merchant merchant, CreditCardToken creditCardToken) {
		this.language = language;
		this.command = command;
		this.merchant = merchant;
		this.creditCardToken = creditCardToken;
	}
	
	@Override
	public String toString() {
		return "TokenRequest [language: " + language + ", command: " + command + ", merchant: " + merchant
				+ ", creditCardToken: " + creditCardToken + "]";
	}

	public String toJSON() {
		return "{\"language\": \"" + language + "\", \"command\": \"" + command + "\", \"merchant\": " + merchant.toString()
				+ ", \"creditCardToken\": " + creditCardToken.toTokenRequest() + "}";
	}
	
}
