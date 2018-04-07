package com.github.luksrn.hitbtc.cli.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import com.github.luksrn.hitbtc.cli.http.ListOrdersRequest;

@ShellComponent
@ShellCommandGroup("Hit BTC - Orders")
public class OrdersCommand extends SecuredCommand {

	@Autowired
	ListOrdersRequest listOrdersRequest;
	
	@ShellMethod(value="List of your currently open orders.")
	@ShellMethodAvailability("isAuthenticatedCheck")
	public String listOrders(@ShellOption(defaultValue="")String symbols) {
		System.out.println("Resultado = " +listOrdersRequest.execute(symbols) );
		return "OK";
	}	
}
