package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.cli.http.dto.Order;

@Component
public class HistoryOrdersRequest extends AbstractRequest {

	public Order[] execute() {
		return get("/history/order", Order[].class);				
	}

}
