package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.github.luksrn.hitbtc.cli.http.dto.Order;

@Component
public class CreateOrderRequest extends AbstractRequest {

	public Order execute(
			String symbol,
			String side,
			String quantity,
			String price) {
		
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("symbol", symbol);
		parts.add("side", side);
		parts.add("quantity", quantity);
		parts.add("price", price);
		
		return post("/order", parts, Order.class);
	}
	
}
