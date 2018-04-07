package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.http.dto.Balance;

@Component
public class AccountBalanceRequest extends AbstractRequest {

	public Balance[] execute() {		
		return get("/account/balance", Balance[].class);
	}
	
}
