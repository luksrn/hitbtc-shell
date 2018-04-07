package com.github.luksrn.hitbtc.http.dto;

public class AvailableCurrency {

	private String id;
	
	private String fullName;
	
	private String crypto;
	
	private String payinEnabled;
	
	private String payinPaymentId;
	
	private String payinConfirmations;
	
	private String payoutEnabled;
	
	private String payoutIsPaymentId;
	
	private String transferEnabled;
	
	private String delisted;
	
	private String payoutFee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCrypto() {
		return crypto;
	}

	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}

	public String getPayinEnabled() {
		return payinEnabled;
	}

	public void setPayinEnabled(String payinEnabled) {
		this.payinEnabled = payinEnabled;
	}

	public String getPayinPaymentId() {
		return payinPaymentId;
	}

	public void setPayinPaymentId(String payinPaymentId) {
		this.payinPaymentId = payinPaymentId;
	}

	public String getPayinConfirmations() {
		return payinConfirmations;
	}

	public void setPayinConfirmations(String payinConfirmations) {
		this.payinConfirmations = payinConfirmations;
	}

	public String getPayoutEnabled() {
		return payoutEnabled;
	}

	public void setPayoutEnabled(String payoutEnabled) {
		this.payoutEnabled = payoutEnabled;
	}

	public String getPayoutIsPaymentId() {
		return payoutIsPaymentId;
	}

	public void setPayoutIsPaymentId(String payoutIsPaymentId) {
		this.payoutIsPaymentId = payoutIsPaymentId;
	}

	public String getTransferEnabled() {
		return transferEnabled;
	}

	public void setTransferEnabled(String transferEnabled) {
		this.transferEnabled = transferEnabled;
	}

	public String getDelisted() {
		return delisted;
	}

	public void setDelisted(String delisted) {
		this.delisted = delisted;
	}

	public String getPayoutFee() {
		return payoutFee;
	}

	public void setPayoutFee(String payoutFee) {
		this.payoutFee = payoutFee;
	}
    
}
