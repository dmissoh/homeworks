package com.dmissoh.impl;

import com.dmissoh.guice.api.IGreeter;

public class Greeter implements IGreeter {

	@Override
	public String getGreeting() {
		return "This is the greeting";
	}

}
