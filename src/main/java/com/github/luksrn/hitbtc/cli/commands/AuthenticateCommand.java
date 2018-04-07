package com.github.luksrn.hitbtc.cli.commands;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.github.luksrn.hitbtc.cli.AuthenticationSession;
import com.github.luksrn.hitbtc.cli.args.AuthenticationSessionArgs;

@ShellComponent
public class AuthenticateCommand {
	
	AuthenticationSession auth;
	
	@Autowired
	public AuthenticateCommand(AuthenticationSession auth) {
		super();
		this.auth = auth;
	}

	@ShellMethod(value = "Authenticate with the system")
	public String auth( @ShellOption(optOut=true) @Valid AuthenticationSessionArgs authenticationSession) {
		auth.setAuthenticated(authenticationSession);
		return "Authenticated";
	}
	
	@ShellMethod(value="logout")
	public String logout() {
		auth.setAuthenticated(null);
		return "bye!";
	}
}
