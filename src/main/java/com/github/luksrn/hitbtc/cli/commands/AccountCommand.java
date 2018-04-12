package com.github.luksrn.hitbtc.cli.commands;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.Table;

import com.github.luksrn.hitbtc.cli.TableGenerator;
import com.github.luksrn.hitbtc.cli.http.AccountBalanceRequest;
import com.github.luksrn.hitbtc.cli.http.TransactionRequest;
import com.github.luksrn.hitbtc.cli.http.TransferRequest;
import com.github.luksrn.hitbtc.cli.http.dto.Balance;
import com.github.luksrn.hitbtc.cli.http.dto.Transaction;
import com.github.luksrn.hitbtc.cli.http.dto.TransactionID;

@ShellComponent
@ShellCommandGroup("Hit BTC - Account")
public class AccountCommand extends SecuredCommand {
	
	@Autowired
	AccountBalanceRequest accountRequest;
	
	@Autowired
	TransactionRequest transactionRequest;

	@ShellMethod(value="Get main acccount balance")
	public Table accountBalance(@ShellOption(value= {"-a","--all"},arity=0, defaultValue="false") boolean showAll) {
		
		
		Balance[] balances = Stream.of(accountRequest.execute())
								.filter( b -> showAll || !b.getAvailable().equals("0"))
								.toArray(Balance[]::new);
		
		return new TableGenerator<Balance>()
			.withData(balances)
			.withColumn("Currency", Balance::getCurrency)
			.withColumn("Available", Balance::getAvailable)
			.withColumn("Reserved", Balance::getReserved)
			.toTable();
	}

	@ShellMethod("Get account transactions")
	public Table transactions() {
		
		Transaction[] transactions = transactionRequest.execute();
		    
		return new TableGenerator<Transaction>()
				.withData(transactions)
				.withColumn("ID", Transaction::getId)
				.withColumn("Date", Transaction::getCreatedAt)
				.withColumn("Type", Transaction::getType)
				.withColumn("status", Transaction::getStatus)
				.withColumn("currency", Transaction::getCurrency)
				.withColumn("amount", Transaction::getAmount)
				.withColumn("Address", Transaction::getAddress)
				.toTable();
	}
	
	@Autowired
	private TransferRequest transferRequest;
	
	@ShellMethod("Transfer amount to trading. Default is bank-to-exchange.")
	public String transfer(String currency, String amount, @ShellOption(value= {"--exchangeToBank"},arity=0, defaultValue="false") boolean exchangeToBank) {
		String type = exchangeToBank ? "exchangeToBank" : "bankToExchange";
		
		TransactionID tid = transferRequest.execute(currency, amount, type);
		
		return tid.getId();
	}
}
