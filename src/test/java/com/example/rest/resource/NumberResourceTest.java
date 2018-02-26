package com.example.rest.resource;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.example.rest.service.NumberService;

public class NumberResourceTest {
	private static List<Long> FIRST_SEVEN;
	private NumberResource resource;
	
	static {
		Long[] list = { 1L, 1L, 2L, 3L, 5L, 8L, 13L };
		FIRST_SEVEN = new ArrayList<Long>(Arrays.asList(list));
	}
	
	@Before
	public void setUp() {
		resource = new NumberResource();
		resource.setNumberService(new NumberService());
	}

	@Test
	public void numberInRange() {
		Response response = resource.getFibonacciNumbers(7);
		List<Long> numberList = (List<Long>) response.getEntity();
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		assertEquals(FIRST_SEVEN, numberList);
	}

	@Test
	public void numberTooSmall() {
		Response response = resource.getFibonacciNumbers(-5);
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}

	@Test
	public void numberTooBig() {
		Response response = resource.getFibonacciNumbers(52);
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
}
