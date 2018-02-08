package com.example.rest.service;

import org.junit.Test;

public class ThreadServiceTest {
	
	@Test
	public void detectDeadlock() {
		ThreadService service = new ThreadService();
		service.startDeadlock();
		assert(service.detectDeadlock().contains("Deadlock occurred"));
	}

}
