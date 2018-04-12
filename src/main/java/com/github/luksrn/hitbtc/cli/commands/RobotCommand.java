package com.github.luksrn.hitbtc.cli.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.github.luksrn.hitbtc.cli.http.SymbolCurrencyPairRequest;
import com.github.luksrn.hitbtc.cli.http.dto.SymbolCurrencyPair;

@ShellComponent
public class RobotCommand {
	
	@Autowired
	SymbolCurrencyPairRequest symbolRequest;

	@ShellMethod("Robô")
	public String robo(
					@ShellOption(help="Moeda que deseja-se comprar") String base,
					@ShellOption(help="MOeda que vai ser utilizada para compra") String quote,
					@ShellOption String valor,
					@ShellOption String percentagem) {
		
		
		String symbol = base.toUpperCase() + quote.toUpperCase();
		SymbolCurrencyPair[] pairs = symbolRequest.execute(symbol);
		
		if( pairs.length != 1 ) {
			System.err.println("Não foi possível encontrar Symbol");
		}
		SymbolCurrencyPair pair = pairs[0];
		System.out.println("Operando em " + pair.getId() );
		return "Hash: 2643gt4w35g353hgq3";
	}
}
