package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

@Component
public class CancelOrderRequest extends AbstractRequest {

	public void execute(String clientOrderId) {
		delete("/order/" + clientOrderId);
	}
	
}
