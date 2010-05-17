package com.dmissoh;

import com.dmissoh.guice.api.IGreeter;
import com.dmissoh.impl.GreetingConsumer;
import com.dmissoh.module.GreetingModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new GreetingModule());
		IGreeter greeterService = injector.getInstance(IGreeter.class);

		GreetingConsumer gc = new GreetingConsumer(greeterService);
		gc.sayHi();
	}

}
