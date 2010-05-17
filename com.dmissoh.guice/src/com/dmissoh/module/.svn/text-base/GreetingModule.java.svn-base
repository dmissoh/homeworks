package com.dmissoh.module;

import com.dmissoh.guice.api.IGreeter;
import com.dmissoh.impl.Greeter;
import com.google.inject.AbstractModule;

public class GreetingModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(IGreeter.class).to(Greeter.class);
	}
}