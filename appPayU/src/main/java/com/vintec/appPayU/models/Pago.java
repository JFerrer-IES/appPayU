package com.vintec.appPayU.models;

public class Pago {

	
	private String lenguage="es";
	private String command="SUBMIT_TRANSACTION";
	private Merchant merchant;
	private Transaction transaction;
	private Boolean test= true;
	
	public Boolean getTest() {
		return test;
	}

	public String getLenguage() {
		return lenguage;
	}
	public String getCommand() {
		return command;
	}
	
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Pago( Merchant merchant, Transaction transaction) {
		super();
		this.merchant = merchant;
		this.transaction= transaction;
	}
	
	

public String toJsonPago() {
	return "{ \"language\": \""+lenguage+"\", \"command\": \""+command+"\","+merchant.toString()+transaction.toJsonTransaction()+"\"test\":"+test+"}";			
}		
		
	
	
	

}
