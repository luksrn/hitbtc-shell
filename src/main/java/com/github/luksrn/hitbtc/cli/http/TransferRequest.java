package com.github.luksrn.hitbtc.cli.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.github.luksrn.hitbtc.http.dto.TransactionID;

@Component
public class TransferRequest extends AbstractRequest {

	public TransactionID execute(String currency, String amount, String type) {
		
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("currency", currency);
		parts.add("amount", amount);
		parts.add("type", type);
		return post("/account/transfer", parts, TransactionID.class);
	}
	
}
