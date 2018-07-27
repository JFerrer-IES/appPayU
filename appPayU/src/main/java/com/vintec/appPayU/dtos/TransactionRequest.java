package com.vintec.appPayU.dtos;

import com.vintec.appPayU.models.Usuario;

public class TransactionRequest {
	private OrderRequest order;
	private Usuario payer;
	private CreditCardRequest creditCard;
	private String type= "AUTHORIZATION_AND_CAPTURE";
	private String paymentCountry= "MX";
	private String deviceSessionId="vghs6tvkcle931686k1900o6e1";
	private String ipAddress= "127.0.0.1";
	private String cookie= "pt1t38347bs6jc9ruv2ecpv7o2";
	private String userAgent= "Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0";
	public OrderRequest getOrder() {
		return order;
	}
	public Usuario getPayer() {
		return payer;
	}
	public CreditCardRequest getCreditCard() {
		return creditCard;
	}
	public String getType() {
		return type;
	}

	public String getPaymentCountry() {
		return paymentCountry;
	}
	public String getDeviceSessionId() {
		return deviceSessionId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public String getCookie() {
		return cookie;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setOrder(OrderRequest order) {
		this.order = order;
	}
	public void setPayer(Usuario payer) {
		this.payer = payer;
	}
	public void setCreditCard(CreditCardRequest creditCard) {
		this.creditCard = creditCard;
	}
	
	public TransactionRequest(OrderRequest order, Usuario payer, CreditCardRequest creditCard) {
		super();
		this.order = order;
		this.payer = payer;
		this.creditCard = creditCard;
	}
	
	public String toJsonTransaction()
	{
		return "\"transaction\": {" +order.toJsonOrder()+ payer.toJasonPayer()+creditCard.toJsonCreditCard()+"\"type\": \""+type+"\",\"paymentMethod\": \""+creditCard.getPaymentMethod()+"\","
				+ "\"paymentCountry\": \""+paymentCountry+"\", \"deviceSessionId\": \""+deviceSessionId+"\",\"ipAddress\": \""+deviceSessionId+"\",\"cookie\": \""+cookie+"\","
						+ "\"userAgent\": \""+userAgent+"\"},";
	}
	

	
	

}
