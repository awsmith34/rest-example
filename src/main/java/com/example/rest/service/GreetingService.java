package com.example.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A simple greeting service.
 */
@Service
public class GreetingService {
	private static final Logger LOG = LoggerFactory.getLogger(GreetingService.class);
	
	private static final String GREETING = "Hello world";

	/**
	 * Returns a simple greeting.
	 * 
	 * @return A greeting
	 */
	public String getGreeting() {
		LOG.debug("Retrieving greeting");
		return GREETING;
	}
}
