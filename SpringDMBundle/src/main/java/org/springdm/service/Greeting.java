package org.springdm.service;

public class Greeting implements IGreeting {

	public Greeting() {
		System.out.println(">>> Constructing Greeting Service...");
	}

	public void greet() {
		System.out.println(">>> Excecuting greet...");
	}

}
