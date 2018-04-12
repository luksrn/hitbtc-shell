package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.cli.http.dto.AvailableCurrency;

@Component
public class AvailableCurrenciesRequest extends AbstractRequest {
	
	public AvailableCurrency[] execute(String currency) {
		if(currency.isEmpty()) {
			return get("public/currency/", AvailableCurrency[].class);	
		}
		
		return new AvailableCurrency[] {
				get("/public/currency/" + currency, AvailableCurrency.class)
		};
	} 
	
}
