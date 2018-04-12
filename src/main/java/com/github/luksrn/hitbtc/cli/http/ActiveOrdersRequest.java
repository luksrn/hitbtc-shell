package com.github.luksrn.hitbtc.cli.http;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.cli.http.dto.Order;

@Component
public class ActiveOrdersRequest extends AbstractRequest {

	public Order[] execute(String clientOrderId) {
		
		if(clientOrderId.isEmpty()) {
			return get("/order", Order[].class);				
		}
		
		return new Order[] {
				get("/order/" + clientOrderId, Order.class)
		};
	}

}
