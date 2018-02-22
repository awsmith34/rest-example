package com.example.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.rest.resource.CarResource;
import com.example.rest.resource.GreetingResource;
import com.example.rest.resource.NumberResource;
import com.example.rest.resource.ParagraphResource;
import com.example.rest.resource.PostResource;
import com.example.rest.resource.ThreadResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(GreetingResource.class);
		register(ParagraphResource.class);
		register(NumberResource.class);
		register(ThreadResource.class);
		register(PostResource.class);
		register(CarResource.class);
	}
}
