package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.http.dto.Balance;

@Component
public class TradingBalanceRequest extends AbstractRequest {
	
	public Balance[] execute() {
		return get("/trading/balance", Balance[].class);
	}
	

}
