package com.example.rest.service;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.rest.model.Paragraph;

/**
 * A service that operates on paragraphs.
 */
@Service
public class ParagraphService {
	private static final Logger LOG = LoggerFactory.getLogger(ParagraphService.class);

	private static final String NON_WORD_PATTERN = "[^a-zA-Z’0-9_-]+";

	/**
	 * Performs a single procedure that receives a paragraph as input, and returns
	 * the list of unique words within the paragraph. A word is defined by any
	 * consecutive alpha-numeric characters. In addition, the special characters
	 * apostrophe (’), underscore (_), and hyphen (-) are included as valid
	 * characters within a word. Case is ignored when comparing words for equality,
	 * and the returned words will all be in lower-case.
	 * 
	 * NOTE: The single tick (') cannot be substituted for the apostrophe (’)
	 * 
	 * @param paragraph
	 * @return A mapping of words to their occurrences in the paragraph.
	 */
	public Map<String, Integer> getWordCount(Paragraph paragraph) {
		Map<String, Integer> wordMap = new TreeMap<>();
		if (paragraph == null || paragraph.getContent() == null) {
			LOG.warn("Paragraph of content was null, returning empty map");
			return wordMap;
		}

		LOG.debug("Calculating word count for paragraph\n{}", paragraph.getContent());
		String[] words = paragraph.getContent().toLowerCase().split(NON_WORD_PATTERN);
		for (String word : words) {
			if (word.trim().equals("")) {
				continue;
			}

			Integer count = wordMap.get(word);
			if (count == null) {
				wordMap.put(word, 1);
			} else {
				wordMap.put(word, count + 1);
			}
		}

		LOG.debug("Finished calculating word count, {} unique words", wordMap.size());
		return wordMap;
	}
}
