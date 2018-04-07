package com.github.luksrn.hitbtc.cli.commands;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.Table;

import com.github.luksrn.hitbtc.cli.TableGenerator;
import com.github.luksrn.hitbtc.cli.http.TradingBalanceRequest;
import com.github.luksrn.hitbtc.http.dto.Balance;


@ShellComponent
@ShellCommandGroup("Hit BTC - Orders")
public class TraddingCommand extends SecuredCommand {
	
	@Autowired
	TradingBalanceRequest tradingBalanceRequest;
	

	@ShellMethod(value="Get trading balance")
	public Table traddingBalance(@ShellOption(value= {"-a","--all"},arity=0, defaultValue="false") boolean showAll) {
		Balance[] balances = Stream.of(tradingBalanceRequest.execute())
								.filter( b -> showAll || !b.getAvailable().equals("0"))
								.toArray(Balance[]::new);
		
		return new TableGenerator<Balance>()
			.withData(balances)
			.withColumn("Currency", Balance::getCurrency)
			.withColumn("Available", Balance::getAvailable)
			.withColumn("Reserved", Balance::getReserved)
			.toTable();
	}
}
