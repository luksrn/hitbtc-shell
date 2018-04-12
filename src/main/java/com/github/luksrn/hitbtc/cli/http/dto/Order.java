package com.github.luksrn.hitbtc.cli.http.dto;

public class Order {
	
	/**
	 * Unique identifier for Order as assigned by exchange
	 */
	 private String id; 
	 /**
	  * Unique identifier for Order as assigned by trader. Uniqueness must be guaranteed within a single trading day, including all active orders.
	  */
	 private String clientOrderId;
	 
	 private String symbol;
	 /**
	  * Seel or Buy.
	  */
	 private String side;
	 
	 /**
	  * new, suspended, partiallyFilled, filled, canceled, expired
	  */
	 private String status;
	 
	 /**
	  * Enum: limit, market, stopLimit, stopMarket
	  */
	 private String type;
	 
	 /**
	  * Time in force is a special instruction used when placing a trade to indicate how long an order will remain active before it is executed or expires
		GTC - Good till cancel. GTC order won't close until it is filled.
		IOC - An immediate or cancel order is an order to buy or sell that must be executed immediately, and any portion of the order that cannot be immediately filled is cancelled.
		FOK - Fill or kill is a type of time-in-force designation used in securities trading that instructs a brokerage to execute a transaction immediately and completely or not at all.
		Day - keeps the order active until the end of the trading day in UTC.
		GTD - Good till date specified in expireTime.
	  */
	 private String timeInForce;
	 /**
	  * 
	  */
	 private String price;
	 /**
	  * Order quantity
	  */
	 private String quantity;
	 /**
	  * Cumulative executed quantity
	  */
	 private String cumQuantity;
	 
	 private String createdAt;
	 
	 private String updatedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientOrderId() {
		return clientOrderId;
	}

	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimeInForce() {
		return timeInForce;
	}

	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCumQuantity() {
		return cumQuantity;
	}

	public void setCumQuantity(String cumQuantity) {
		this.cumQuantity = cumQuantity;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
}
