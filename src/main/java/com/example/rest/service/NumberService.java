package com.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A service that performs numeric operations.
 */
@Service
public class NumberService {
	private static final Logger LOG = LoggerFactory.getLogger(NumberService.class);

	/**
	 * Performs a single procedure that takes a single number n as input and returns
	 * the first n Fibonacci numbers. Due to the slow performance of the
	 * implementation, the number must be between 0 and 48 inclusively. If the
	 * number is out of the range, the endpoint will respond with a bad request
	 * message.
	 * 
	 * @param count
	 * @return The first count Fibonacci numbers
	 * @throws InvalidNumberException
	 */
	public List<Long> getFibonacciNumbers(int count) throws InvalidNumberException {
		LOG.debug("Calculating the first {} fibonacci numbers", count);
		if (count < 0 || count > 48) {
			String message = String.format("Invalid count %d: must be between 0 and 48 inclusive", count);
			LOG.error(message);
			throw new InvalidNumberException(message);
		}

		List<Long> numbers = new ArrayList<>(count);
		for (int i = 1; i <= count; i++) {
			numbers.add(fibonacci(i));
		}

		return numbers;
	}

	private long fibonacci(int i) {
		if (i <= 2) {
			return 1;
		}
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}
