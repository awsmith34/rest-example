package com.example.rest.resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.example.rest.service.ThreadService;

public class ThreadResourceTest {
	private static final String DEADLOCK_MESSAGE_START = "Deadlock occurred in threads";
	
	private ThreadResource resource;
	
	@Before
	public void setUp() {
		resource = new ThreadResource();
		resource.setThreadService(new ThreadService());
	}

	@Test
	public void detectDeadlock() {
		Response response = resource.deadlock();
		String message = (String) response.getEntity(); 
		assertNotNull(message);
		assertTrue(message.startsWith(DEADLOCK_MESSAGE_START));
	}

}
