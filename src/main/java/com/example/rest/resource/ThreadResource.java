package com.example.rest.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.service.ThreadService;

@Component
@Path("/threads")
public class ThreadResource {
	
	@Autowired
	private ThreadService service;

	@POST
	@Path("/deadlock")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deadlock() {
		service.startDeadlock();
		String message = service.detectDeadlock();
		return Response.ok(message).build();
	}

	public void setThreadService(ThreadService service) {
		this.service = service;
	}
}
