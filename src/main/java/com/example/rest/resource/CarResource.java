package com.example.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.model.Car;
import com.example.rest.service.CarService;

@Component
@Path("/cars")
public class CarResource {
	
	@Autowired
	private CarService service;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Long id) {
		Car car = service.get(id);
		if (car == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok(car).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Car car, @Context UriInfo uriInfo) {
		service.create(car);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(Long.toString(car.getId()));
		return Response.created(uriBuilder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Car car) {
		service.update(car);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		service.delete(id);
		return Response.ok().build();
	}
}
