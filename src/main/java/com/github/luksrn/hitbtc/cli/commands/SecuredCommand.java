package com.github.luksrn.hitbtc.cli.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.stereotype.Component;

import com.github.luksrn.hitbtc.cli.AuthenticationSession;

@Component
public abstract class SecuredCommand {
	
	@Autowired
	AuthenticationSession auth;

	@ShellMethodAvailability
	public Availability isAuthenticatedCheck() {
        return auth.isAuthenticated()
            ? Availability.available()
            : Availability.unavailable("you are not authenticated. (see 'help auth')");
    }
}
