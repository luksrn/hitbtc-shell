package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.cli.http.dto.Transaction;

@Component
public class TransactionRequest extends AbstractRequest {

	public Transaction[] execute() {
		return get("/account/transactions?sort=DESC&by=timestamp&limit=100", Transaction[].class);
	}
	
}
