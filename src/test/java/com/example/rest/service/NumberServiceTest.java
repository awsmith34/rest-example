package com.example.rest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class NumberServiceTest {

	private NumberService service;
	
	@Before
	public void setUp() {
		service = new NumberService();
	}
	
	@Test
	public void smallCount() {
		try {
			List<Long> numberList = service.getFibonacciNumbers(8);
			assertEquals(8, numberList.size());
			Long[] expectedValues = { 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L };
			assertEquals(Arrays.asList(expectedValues), numberList);
		} catch (InvalidNumberException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}
	
	@Test
	public void mediumCount() {
		try {
			List<Long> numberList = service.getFibonacciNumbers(27);
			assertEquals(27, numberList.size());
		} catch (InvalidNumberException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void maxCount() {
		try {
			List<Long> numberList = service.getFibonacciNumbers(48);
			assertEquals(48, numberList.size());
		} catch (InvalidNumberException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void minCount() {
		try {
			List<Long> numberList = service.getFibonacciNumbers(0);
			assert(numberList.isEmpty());
		} catch (InvalidNumberException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}
	
	@Test(expected=InvalidNumberException.class)
	public void negativeCount() throws InvalidNumberException {
		List<Long> numberList = service.getFibonacciNumbers(-5);
	}
	
	@Test(expected=InvalidNumberException.class)
	public void largeCount() throws InvalidNumberException {
		List<Long> numberList = service.getFibonacciNumbers(90);
	}
}
