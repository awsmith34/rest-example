package com.example.rest.service;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.rest.model.Paragraph;

@Service
public class ParagraphService {
	private static final Logger LOG = LoggerFactory.getLogger(ParagraphService.class);

	private static final String NON_WORD_PATTERN = "[^a-zA-Z’0-9_-]+";
	
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
			}
			else {
				wordMap.put(word,  count + 1);
			}
		}

		LOG.debug("Finished calculating word count, {} unique words", wordMap.size());
		return wordMap;
	}
}
