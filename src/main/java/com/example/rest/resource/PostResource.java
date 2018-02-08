package com.example.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.client.PostClient;
import com.example.rest.model.Post;

@Component
@Path("/posts")
public class PostResource {
	
	@Autowired
	private PostClient postClient;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPosts() {
		Post[] posts = postClient.getPosts();
		return Response.ok(posts).build();
	}
}
