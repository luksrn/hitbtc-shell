package com.github.luksrn.hitbtc.cli.args;

import javax.validation.constraints.NotEmpty;

import com.beust.jcommander.Parameter;

public class AuthenticationSessionArgs {

	@NotEmpty
	@Parameter(names= {"-pkey", "--public-key"},description="API public key",required=true)
	private String pKey;
	
	@NotEmpty
	@Parameter(names= {"-skey", "--secret-key"},description="API secret key, required on BASIC algo",required=true)
	private String sKey;
	
	public String getpKey() {
		return pKey;
	}

	public void setpKey(String pKey) {
		this.pKey = pKey;
	}

	public String getsKey() {
		return sKey;
	}

	public void setsKey(String sKey) {
		this.sKey = sKey;
	}
}
