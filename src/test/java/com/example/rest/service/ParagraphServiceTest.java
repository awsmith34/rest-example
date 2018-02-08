package com.example.rest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.example.rest.model.Paragraph;

public class ParagraphServiceTest {

	private ParagraphService service;
	private Paragraph paragraph;

	@Before
	public void setUp() {
		service = new ParagraphService();
		paragraph = new Paragraph();
	}

	@Test
	public void simpleSentence() {
		paragraph.setContent("He told us a very exciting adventure story.");
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		validateCount(1, wordMap.get("told"));
		validateCount(1, wordMap.get("he"));
		validateCount(0, wordMap.get("He"));
		validateCount(1, wordMap.get("story"));
		validateCount(0, wordMap.get("story."));
		validateCount(0, wordMap.get("them"));
	}

	@Test
	public void multipleSentences() {
		paragraph.setContent(
				"He told us a very exciting adventure story. He ran out of money, so he had to stop playing poker.");
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		validateCount(1, wordMap.get("told"));
		validateCount(1, wordMap.get("exciting"));
		validateCount(3, wordMap.get("he"));
		validateCount(1, wordMap.get("money"));
		validateCount(0, wordMap.get("money."));
	}

	@Test
	public void hyphenatedWords() {
		paragraph.setContent(
				"I just saw my mother-in-law. My mother-in-law is quick-thinking");
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		validateCount(0, wordMap.get("mother"));
		validateCount(0, wordMap.get("law"));
		validateCount(2, wordMap.get("mother-in-law"));
		validateCount(0, wordMap.get("quick"));
		validateCount(1, wordMap.get("quick-thinking"));
	}

	@Test
	public void apostropheWords() {
		paragraph.setContent(
				"It didn’t and they don’t recommend anyone else do it either.");
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		validateCount(0, wordMap.get("don"));
		validateCount(1, wordMap.get("don’t"));
		validateCount(0, wordMap.get("didn"));
		validateCount(1, wordMap.get("didn’t"));
	}

	@Test
	public void punctuation() {
		paragraph.setContent(
				"What was the person thinking;;; when they discovered cow’s milk was fine for human consumption… and why did they do it in the first place!?");
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		validateCount(1, wordMap.get("thinking"));
		validateCount(1, wordMap.get("cow’s"));
		validateCount(1, wordMap.get("consumption"));
		validateCount(0, wordMap.get("!?"));
	}

	@Test
	public void numbers() {
		paragraph.setContent(
				"There are 12 months and 365 days in a non-leap year. My favorite number is 12.");
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		validateCount(1, wordMap.get("365"));
		validateCount(2, wordMap.get("12"));
	}

	@Test
	public void emptyContent() {
		paragraph.setContent("");
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		assertTrue(wordMap.isEmpty());
	}

	@Test
	public void nullContent() {
		Map<String, Integer> wordMap = service.getWordCount(paragraph);
		assertTrue(wordMap.isEmpty());
	}

	@Test
	public void nullParagraph() {
		Map<String, Integer> wordMap = service.getWordCount(null);
		assertTrue(wordMap.isEmpty());
	}

	private void validateCount(int expected, Integer actual) {
		if (actual == null) {
			assertEquals(expected, 0);
		} else {
			assertEquals(expected, actual.intValue());
		}
	}
}
