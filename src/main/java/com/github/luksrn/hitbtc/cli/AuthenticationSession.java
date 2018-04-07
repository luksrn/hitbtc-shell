package com.github.luksrn.hitbtc.cli;

import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.cli.args.AuthenticationSessionArgs;

@Component
public class AuthenticationSession {

	private boolean authenticated = false;
	
	private AuthenticationSessionArgs tokens;
	
	public void setAuthenticated(AuthenticationSessionArgs args) {
		tokens = args;
		this.authenticated = args != null;
	}
	
	public AuthenticationSessionArgs getTokens() {
		return tokens;
	}
	
	public boolean isAuthenticated() {
		return authenticated; 
	}
}
