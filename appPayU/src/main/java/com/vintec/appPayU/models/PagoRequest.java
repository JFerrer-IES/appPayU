package com.vintec.appPayU.models;

public class PagoRequest {

	private String lenguage="es";
	private String command="SUBMIT_TRANSACTION";
	private MerchantRequest merchant;
	private TransactionRequest transaction;
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
	
	public MerchantRequest getMerchant() {
		return merchant;
	}
	public void setMerchant(MerchantRequest merchant) {
		this.merchant = merchant;
	}
	public PagoRequest(MerchantRequest merchant, TransactionRequest transaction) {
		super();
		this.merchant = merchant;
		this.transaction= transaction;
	}
	
	

public String toJsonPago() {
	return "{ \"language\": \""+lenguage+"\", \"command\": \""+command+"\","+merchant.toString()+transaction.toJsonTransaction()+"\"test\":"+test+"}";			
}		
		
	
	
	

}
