package com.example.rest.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.example.rest.model.Paragraph;
import com.example.rest.model.WordCount;
import com.example.rest.service.ParagraphService;

public class ParagraphResourceTest {
	private static final String CONTENT = "I am not a sentence. I'm a paragraph.";
	
	private ParagraphResource resource;
	private Paragraph paragraph;
	
	@Before
	public void setUp() {
		resource = new ParagraphResource();
		resource.setParagraphService(new ParagraphService());
		paragraph = new Paragraph();
		paragraph.setContent(CONTENT);
	}

	@Test
	public void countWords() {
		Response response = resource.countWords(paragraph);
		List<WordCount> wordCountList = (List<WordCount>) response.getEntity();
		for (WordCount wordCount : wordCountList) {
			if ("I".equals(wordCount.getWord())) {
				assertEquals(1, wordCount.getCount());
			}
			else if ("a".equals(wordCount.getWord())) {
				assertEquals(2, wordCount.getCount());
			}
			else if ("sentence".equals(wordCount.getWord())) {
				assertEquals(1, wordCount.getCount());
			}
		}
	}

}
