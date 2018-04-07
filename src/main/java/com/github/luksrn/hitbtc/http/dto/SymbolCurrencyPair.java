package com.github.luksrn.hitbtc.http.dto;

/**
 * 
 * 
 * A widely traded currency pair is the euro against the U.S. dollar, or shown as EUR/USD. 
 * The quotation EUR/USD = 1.2500 means that one euro is exchanged for 1.2500 U.S. dollars. 
 * 
 * In this case, EUR is the base currency and USD is the quote currency (counter currency). 
 * 
 * This means that 1 euro can be exchanged for 1.25 U.S. dollars. 
 * Another way of looking at this is that it will cost you $125 to buy EUR 100.
 *
 */
public class SymbolCurrencyPair {
	
	private String id;
	
	private String baseCurrency;
	
	private String quoteCurrency;
	
	// A quantidade que se pode comprar
	private String quantityIncrement;
	
	private String tickSize;
	
	private String takeLiquidityRate;
	
	private String provideLiquidityRate;
	
	private String feeCurrency;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getQuoteCurrency() {
		return quoteCurrency;
	}

	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}

	public String getQuantityIncrement() {
		return quantityIncrement;
	}

	public void setQuantityIncrement(String quantityIncrement) {
		this.quantityIncrement = quantityIncrement;
	}

	public String getTickSize() {
		return tickSize;
	}

	public void setTickSize(String tickSize) {
		this.tickSize = tickSize;
	}

	public String getTakeLiquidityRate() {
		return takeLiquidityRate;
	}

	public void setTakeLiquidityRate(String takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
	}


	public String getProvideLiquidityRate() {
		return provideLiquidityRate;
	}
	
	public void setProvideLiquidityRate(String provideLiquidityRate) {
		this.provideLiquidityRate = provideLiquidityRate;
	}
	
	public String getFeeCurrency() {
		return feeCurrency;
	}

	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}
	
}
