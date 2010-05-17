package com.dmissoh.impl;

import com.dmissoh.guice.api.IGreeter;

public class GreetingConsumer {

	private IGreeter greeter;

	public GreetingConsumer(IGreeter greeter) {
		this.greeter = greeter;
	}

	public void sayHi() {
		if (getGreeter() != null) {
			System.out.println("The message returned by the greeter is: "
					+ getGreeter().getGreeting());
		}
	}

	public IGreeter getGreeter() {
		return greeter;
	}

	public void setGreeter(IGreeter greeter) {
		this.greeter = greeter;
	}

}
