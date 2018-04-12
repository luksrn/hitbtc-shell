package com.github.luksrn.hitbtc.cli.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.Table;

import com.github.luksrn.hitbtc.cli.TableGenerator;
import com.github.luksrn.hitbtc.cli.http.ActiveOrdersRequest;
import com.github.luksrn.hitbtc.cli.http.CancelOrderRequest;
import com.github.luksrn.hitbtc.cli.http.CreateOrderRequest;
import com.github.luksrn.hitbtc.cli.http.HistoryOrdersRequest;
import com.github.luksrn.hitbtc.cli.http.dto.Order;

@ShellComponent
@ShellCommandGroup("Hit BTC - Orders")
public class OrdersCommand extends SecuredCommand {

	@Autowired
	ActiveOrdersRequest activeOrdersRequet;
	
	@Autowired
	CreateOrderRequest createOrderRequest;
	
	@Autowired
	CancelOrderRequest cancelOrderRequest;
	
	@Autowired
	HistoryOrdersRequest historyOrdersRequest;
	
	@ShellMethod(value="List of your currently open orders.")
	public Table order(@ShellOption("--history") boolean history,
						@ShellOption(value= {"-l","--list"},
									defaultValue="") String clientOrderId ) {
		
		Order[] orders = {};
		if(history) {
			orders = historyOrdersRequest.execute();
		} else {
			orders = activeOrdersRequet.execute(clientOrderId);
		}
		
		return parseToTable(orders);
	}
	
	/// 'symbol':'ethbtc', 'side': 'sell', 'quantity': '0.063', 'price': '0.046016'
	@ShellMethod(value="Create order.")
	public Table createOrder(@ShellOption(value= {"--symbol"}) String symbol,
								@ShellOption(value="--side",
												help="sell or buy") String side,
								@ShellOption(value="--type",
									help="Default - limit. One of: limit, market, stopLimit, stopMarket",
									defaultValue="limit") String type,
								@ShellOption(value="--type",
									help=" Default - GDC. One of: GTC, IOC, FOK, Day, GTD",
									defaultValue="GDC") String timeInForce,
								@ShellOption(value="--quantity") String quantity,
								@ShellOption(value="--price") String price) {
		
		Order order = createOrderRequest.execute(symbol, side, quantity, price);
		return parseToTable(new Order [] { order } );
	
	}
	
	
	@ShellMethod(value="Cancel order.")
	public String cancelOrder(@ShellOption(value="--clientOrderId") String clientOrderId) {		
		cancelOrderRequest.execute(clientOrderId);
		return "OK";
	}
	

	private Table parseToTable(Order[] orders) {
		return new TableGenerator<Order>()
				.withData(orders)
				.withColumn("ID", Order::getId)
				.withColumn("symbol", Order::getSymbol)
				.withColumn("side", Order::getSide)
				.withColumn("status", Order::getStatus)
				.withColumn("TimeInForce", Order::getTimeInForce)
				.withColumn("quantity", Order::getQuantity)
				.withColumn("pricy", Order::getPrice)
				.withColumn("CumQuantity", Order::getCumQuantity)
				.toTable();
	}	

}
