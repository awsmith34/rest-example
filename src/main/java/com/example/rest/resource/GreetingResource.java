package com.example.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.service.GreetingService;

@Component
@Path("/greeting")
public class GreetingResource {
	
	@Autowired
	GreetingService greetingService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getGreeting() {
		return Response.ok(greetingService.getGreeting()).build();
	}
}
