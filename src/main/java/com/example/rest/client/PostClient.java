package com.example.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.rest.model.Post;

/**
 * A simple REST client that calls the remote service and returns the response.
 * The remote service is located at https://jsonplaceholder.typicode.com/posts.
 */
@Component
public class PostClient {
	private static final Logger LOG = LoggerFactory.getLogger(PostClient.class);
	
	private static final String URL = "https://jsonplaceholder.typicode.com/posts";
	
	/**
	 * Calls the remote service
	 * @return an array of Post
	 */
	public Post[] getPosts() {
		LOG.debug("Calling remote api {}", URL);
		RestTemplate restTemplate = new RestTemplate();
		Post[] posts = restTemplate.getForObject(URL, Post[].class);
		return posts;
	}
}
