package com.example.rest.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class PostTest {
	private static final int USER_ID_1 = 14;
	private static final int ID_1 = 123456;
	private static final String TITLE_1 = "Java Lambdas and Low Latency";
	private static final String BODY_1 = "The main question around the use of Lambdas in Java and Low Latency is; Does they produce garbage and is there anything you can do about it? ";
	private static final int USER_ID_2 = 15;
	private static final int ID_2 = 123457;
	private static final String TITLE_2 = "10 Things You Didn’t Know About Java";
	private static final String BODY_2 = "So, you’ve been working with Java since the very beginning? Remember the days when it was called “Oak”, when OO was still a hot topic, when C++ folks thought that Java had no chance, when Applets were still a thing?\n" + 
			"\n" + 
			"I bet that you didn’t know at least half of the following things. Let’s start this week with some great surprises about the inner workings of Java.";
	
	private Post post1;
	
	@Before
	public void setUp() {
		post1 = new Post(USER_ID_1, ID_1, TITLE_1, BODY_1);
	}

	@Test
	public void equalPosts() {
		Post post2 = new Post();
		post2.setUserId(USER_ID_1);
		post2.setId(ID_1);
		post2.setTitle(TITLE_1);
		post2.setBody(BODY_1);
		assertEquals(post1, post1);
		assertEquals(post1, post2);
		assertEquals(post1.hashCode(), post2.hashCode());
	}

	@Test
	public void unequalPosts() {
		Post post2 = new Post(USER_ID_2, ID_2, TITLE_2, BODY_2);
		assertNotEquals(post1, post2);
		assertNotEquals(post1, post2);
		assertNotEquals(post1.hashCode(), post2.hashCode());

		post2.setUserId(USER_ID_1);
		assertNotEquals(post1, post2);

		post2.setId(ID_1);
		assertNotEquals(post1, post2);
		
		post2.setTitle(TITLE_1);
		assertNotEquals(post1, post2);
		
		post1.setTitle(null);
		assertNotEquals(post1, post2);
	}

	@Test
	public void equalPostsWithNull() {
		post1.setTitle(null);
		post1.setBody(null);
		Post post2 = new Post(USER_ID_1, ID_1, null, null);
		assertEquals(post1, post1);
		assertEquals(post1, post2);
		assertEquals(post1.hashCode(), post2.hashCode());
	}
	
	@Test
	public void equalsNull() {
		assertFalse(post1.equals(null));
	}
	
	@Test
	public void equalsNonPost() {
		assertFalse(post1.equals(new Object()));
	}
}
