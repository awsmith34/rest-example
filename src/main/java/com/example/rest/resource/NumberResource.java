package com.example.rest.resource;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.service.InvalidNumberException;
import com.example.rest.service.NumberService;

@Component
@Path("/numbers")
public class NumberResource {
	
	@Autowired
	private NumberService numberService;
	
	@POST
	@Path("/fibonacci/{count}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFibonacciNumbers(@PathParam("count") Integer count) {
		List<Long> numbers;
		try {
			numbers = numberService.getFibonacciNumbers(count);
		}
		catch (InvalidNumberException e) {
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(e.getMessage())
	                .type( MediaType.TEXT_PLAIN)
	                .build();
		}

		return Response.ok(numbers).build();
	}
}
