package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.http.dto.SymbolCurrencyPair;

@Component
public class SymbolCurrencyPairRequest extends AbstractRequest {

	public SymbolCurrencyPair[] execute(String symbol) {
		if(symbol.isEmpty()) {
			return get("/public/symbol/", SymbolCurrencyPair[].class);				
		}
		
		return new SymbolCurrencyPair[] {
				get("/public/symbol/" + symbol, SymbolCurrencyPair.class)
		};
	}
	
}
