package com.github.luksrn.hitbtc.cli.http.dto;

public class TransactionID {

	private String id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
