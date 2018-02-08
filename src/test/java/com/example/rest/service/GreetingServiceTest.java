package com.example.rest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreetingServiceTest {

	@Test
	public void test() {
		assertEquals("Hello world", new GreetingService().getGreeting());
	}
}
