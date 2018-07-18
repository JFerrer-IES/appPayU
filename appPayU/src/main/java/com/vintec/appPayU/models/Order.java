package com.vintec.appPayU.models;

public class Order {
	
	private String accountId="512324";
	private String referenceCode="payment_test_00000001";
	private String description= "payment test";
	private String lenguage="es";
	private String signature="a88cba16c6fc54a4d31f696cfcbd41fc";
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
	public Order(Orden orden, Usuario buyer) {
		super();
		this.orden = orden;
		this.buyer = buyer;
	}
	
	public String toJsonOrder() {
		return "\"order\":{ \"accountId\":\""+accountId+"\",\"referenceCode\": \""+referenceCode+"\", \"description\": \""+description+"\",\"language\": \""+lenguage+"\",\"signature\": \""+signature+"\","+orden.toJsonTotal()+
				buyer.toJasonBuyer()+buyer.toJasonShipping()+"},";
	}
	
	
	
	

}
