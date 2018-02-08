package com.example.rest.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.example.rest.model.Post;

import mockit.Mock;
import mockit.MockUp;

public class PostClientTest {

	@Test
	public void getPosts() {
		Post post1 = new Post(1, 1, "ratione ex tenetur perferendis",
			    "aut et excepturi dicta laudantium sint rerum nihil\nlaudantium et at\na neque minima officia et similique libero et\ncommodi voluptate qui");
		Post post2 = new Post(2, 2, "quam voluptatibus rerum veritatis",
			    "nobis facilis odit tempore cupiditate quia\nassumenda doloribus rerum qui ea\nillum et qui totam\naut veniam repellendus");
		new MockUp<RestTemplate>() {
			@Mock
			<T> T getForObject(String url, Class<T> responseType, Object... urlVariables) {
				Post[] posts = new Post[2];
				posts[0] = post1;
				posts[1] = post2;
				return (T) posts;
			}
		};
		
		PostClient client = new PostClient();
		Post[] result = client.getPosts();
		assertEquals(2, result.length);
	}
	
}
