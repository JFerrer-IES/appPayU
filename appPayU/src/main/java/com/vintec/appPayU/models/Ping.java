package com.vintec.appPayU.models;


public class Ping {

    
	private Boolean test;
	private String lenguage;
	private String command;
	private Merchant merchant;
	
	public Boolean getTest() {
		return test;
	}
	public void setTest(Boolean test) {
		this.test = test;
	}
	public String getLenguage() {
		return lenguage;
	}
	public void setLenguage(String lenguage) {
		this.lenguage = lenguage;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Ping(Boolean test, String lenguage, String command, Merchant merchant) {
		super();
		this.test = test;
		this.lenguage = lenguage;
		this.command = command;
		this.merchant = merchant;
	}
	
	

public String toString() {
	return "{\"test\":"+test+",\"language\":\""+lenguage+"\",\"command\":\""+command+"\","+ merchant.toString()+"}";			
}		
		
	 
}