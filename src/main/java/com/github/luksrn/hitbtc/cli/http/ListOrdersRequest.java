package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

@Component
public class ListOrdersRequest extends AbstractRequest {

	public String execute(String symbol) {
		return get("/order", String.class);
	}
}