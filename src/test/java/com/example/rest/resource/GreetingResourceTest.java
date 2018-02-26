package com.example.rest.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.example.rest.service.GreetingService;

public class GreetingResourceTest {
	private static final String GREETING = "Hello world";

	@Test
	public void greeting() {
		GreetingResource resource = new GreetingResource();
		resource.setGreetingService(new GreetingService());
		Response response = resource.getGreeting();
		assertEquals(GREETING, (String) response.getEntity());
	}

}
