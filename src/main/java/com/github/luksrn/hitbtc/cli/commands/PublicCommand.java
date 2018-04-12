package com.github.luksrn.hitbtc.cli.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.Table;

import com.github.luksrn.hitbtc.cli.TableGenerator;
import com.github.luksrn.hitbtc.cli.http.AvailableCurrenciesRequest;
import com.github.luksrn.hitbtc.cli.http.SymbolCurrencyPairRequest;
import com.github.luksrn.hitbtc.cli.http.dto.AvailableCurrency;
import com.github.luksrn.hitbtc.cli.http.dto.SymbolCurrencyPair;

@ShellComponent
@ShellCommandGroup("Hit BTC - Public")
public class PublicCommand {

	@Autowired
	AvailableCurrenciesRequest availableCurrenciesRequest;
	
	@ShellMethod(key= {"currencies","available-currencies"},value="Get list of avialable currencies.")
	public Table availableCurrencies(@ShellOption(defaultValue="")String currency) {
		
		System.out.println("Searching " + currency + "...");
		
		AvailableCurrency[] resultado =  availableCurrenciesRequest.execute(currency);
		
		System.out.println( resultado.length + " found");
		
		return new TableGenerator<AvailableCurrency>()
			.withData(resultado)
			.withColumn("ID", AvailableCurrency::getId)
			.withColumn("Full Name", AvailableCurrency::getFullName)
			.withColumn("Payout Enabled", AvailableCurrency::getPayoutEnabled)
			.withColumn("Payin Payment Id", AvailableCurrency::getPayinPaymentId)
			.withColumn("Payout Enabled", AvailableCurrency::getPayoutEnabled)
			.withColumn("Transfer Enabled", AvailableCurrency::getTransferEnabled)
			.withColumn("Payout Fee", AvailableCurrency::getPayoutFee)	
			.toTable();
		
	}
	
	@Autowired
	SymbolCurrencyPairRequest symbolCurrencyPairRequest;
	
	@ShellMethod(key= {"symbol"},value="Get list of avialable symbols (Currency Pairs).")
	public Table availableSymbol(@ShellOption(defaultValue="")String symbol) {
		
		System.out.println("Searching " + symbol + "...");
		
		SymbolCurrencyPair[] resultado =  symbolCurrencyPairRequest.execute(symbol);
		
		return new TableGenerator<SymbolCurrencyPair>()
			.withData(resultado)
			.withColumn("ID", SymbolCurrencyPair::getId)
			.withColumn("Base Currency", SymbolCurrencyPair::getBaseCurrency)
			.withColumn("Quote Currency", SymbolCurrencyPair::getQuoteCurrency)
			.withColumn("Quantity Increment", SymbolCurrencyPair::getQuantityIncrement)
			.withColumn("tickSize", SymbolCurrencyPair::getTickSize)
			.withColumn("takeLiquidityRate", SymbolCurrencyPair::getTakeLiquidityRate)
			.withColumn("provideLiquidityRate", SymbolCurrencyPair::getProvideLiquidityRate)
			.withColumn("Fee Currency", SymbolCurrencyPair::getFeeCurrency)
			.toTable();
		
	}
}
