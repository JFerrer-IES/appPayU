package com.vintec.appPayU.models;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class OrderRequest {
	
	private String accountId="512324";
	private String referenceCode="payment_test_99900001";
	private String description= "payment test";
	private String lenguage="es";
	private String signature="69d419f89fb8ed7f80fd7b42bd2ff048";
	private Orden orden;
	private Usuario buyer;
	public String getAccountId() {
		return accountId;
	}
	public String getReferenceCode() {
		return referenceCode;
	}
	public String getDescription() {
		return description;
	}
	public String getLenguage() {
		return lenguage;
	}
	public String getSignature() {
		return signature;
	}
	public Orden getOrden() {
		return orden;
	}
	public Usuario getBuyer() {
		return buyer;
	}
	public OrderRequest(Orden orden, Usuario buyer) {
		super();
		this.orden = orden;
		this.buyer = buyer;
	}
	public String md5() {
		String temp= "";
		return temp;
	}
	
	public static String getMD5(String input) {
		 try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(input.getBytes());
		 BigInteger number = new BigInteger(1, messageDigest);
		 String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
		 hashtext = "0" + hashtext;
		 }
		 return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
		 throw new RuntimeException(e);
		 }
		 }
	
	public String toJsonOrder() {
		return "\"order\":{ \"accountId\":\""+accountId+"\",\"referenceCode\": \""+referenceCode+"\", \"description\": \""+description+"\",\"language\": \""+lenguage+"\",\"signature\": \""+signature+"\","+orden.toJsonTotal()+
				buyer.toJasonBuyer()+buyer.toJasonShipping()+"},";
	}
	
	
	
	

}
