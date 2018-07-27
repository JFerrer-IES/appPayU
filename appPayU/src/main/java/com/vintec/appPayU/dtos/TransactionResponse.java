package com.vintec.appPayU.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TransactionResponse {

	@JsonProperty("orderId")
	private int orderId;
	
	@JsonProperty("transactionId")
	private String transactionId;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("paymentNetworkResponseCode")
	private String paymentNetworkResponseCode;
	
	@JsonProperty("paymentNetworkResponseErrorMessage")
	private String paymentNetworkResponseErrorMessage;
	
	@JsonProperty("trazabilityCode")
	private String trazabilityCode;
	
	@JsonProperty("authorizationCode")
	private String authorizationCode;
	
	@JsonProperty("pendingReason")
	private String pendingReason;
	
	@JsonProperty("responseCode")
	private String responseCode;
	
	@JsonProperty("errorCode")
	private String errorCode;
	
	@JsonProperty("responseMessage")
	private String responseMessage;
	
	@JsonProperty("transactionDate")
	private String transactionDate;
	
	@JsonProperty("transactionTime")
	private String transactionTime;
	
	@JsonProperty("operationDate")
	private String operationDate;
	
	@JsonProperty("extraParameters")
	private String extraParameters;

	public int getOrderId() {
		return orderId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getState() {
		return state;
	}

	public String getPaymentNetworkResponseCode() {
		return paymentNetworkResponseCode;
	}

	public String getPaymentNetworkResponseErrorMessage() {
		return paymentNetworkResponseErrorMessage;
	}

	public String getTrazabilityCode() {
		return trazabilityCode;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public String getPendingReason() {
		return pendingReason;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public String getExtraParameters() {
		return extraParameters;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPaymentNetworkResponseCode(String paymentNetworkResponseCode) {
		this.paymentNetworkResponseCode = paymentNetworkResponseCode;
	}

	public void setPaymentNetworkResponseErrorMessage(String paymentNetworkResponseErrorMessage) {
		this.paymentNetworkResponseErrorMessage = paymentNetworkResponseErrorMessage;
	}

	public void setTrazabilityCode(String trazabilityCode) {
		this.trazabilityCode = trazabilityCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public void setPendingReason(String pendingReason) {
		this.pendingReason = pendingReason;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public void setExtraParameters(String extraParameters) {
		this.extraParameters = extraParameters;
	}
	
	protected TransactionResponse() {}
	
	public TransactionResponse(@JsonProperty("orderId") int orderId, @JsonProperty("transactionId") String transactionId, @JsonProperty("state")String state, 
			@JsonProperty("paymentNetworkResponseCode") String paymentNetworkResponseCode, @JsonProperty("paymentNetworkResponseErrorMessage") String paymentNetworkResponseErrorMessage, 
			@JsonProperty("trazabilityCode") String trazabilityCode, @JsonProperty("authorizationCode") String authorizationCode, @JsonProperty("pendingReason") String pendingReason, 
			@JsonProperty("responseCode") String responseCode, @JsonProperty("errorCode") String errorCode, @JsonProperty("responseMessage") String responseMessage, @JsonProperty("transactionDate") String transactionDate, 
			@JsonProperty("transactionTime") String transactionTime, @JsonProperty("operationDate") String operationDate, @JsonProperty("extraParameters") String extraParameters) {
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.state = state;
		this.paymentNetworkResponseCode = paymentNetworkResponseCode;
		this.paymentNetworkResponseErrorMessage = paymentNetworkResponseErrorMessage;
		this.trazabilityCode = trazabilityCode;
		this.authorizationCode = authorizationCode;
		this.pendingReason = pendingReason;
		this.responseCode = responseCode;
		this.errorCode = errorCode;
		this.responseMessage = responseMessage;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.operationDate = operationDate;
		this.extraParameters = extraParameters;
	}

	@Override
	public String toString() {
		return "transactionResponse: {'orderId'=" + orderId + ", 'transactionId'=" + transactionId + ", 'state'=" + state
				+ ", 'paymentNetworkResponseCode'=" + paymentNetworkResponseCode + ", 'paymentNetworkResponseErrorMessage'="
				+ paymentNetworkResponseErrorMessage + ", 'trazabilityCode'=" + trazabilityCode + ", 'authorizationCode'="
				+ authorizationCode + ", 'pendingReason'=" + pendingReason + ", 'responseCode'=" + responseCode
				+ ", 'errorCode'=" + errorCode + ", 'responseMessage'=" + responseMessage + ", 'transactionDate'="
				+ transactionDate + ", 'transactionTime'=" + transactionTime + ", 'operationDate'=" + operationDate
				+ ", 'extraParameters'=" + extraParameters + "}";
	}

	
}
