package com.example.rest.resource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.model.Paragraph;
import com.example.rest.model.WordCount;
import com.example.rest.service.ParagraphService;

@Component
@Path("/paragraphs")
public class ParagraphResource {

	@Autowired
	private ParagraphService paragraphService;

	@POST
	@Path("/count-words")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response countWords(Paragraph paragraph) {
		Map<String, Integer> wordMap = paragraphService.getWordCount(paragraph);
		List<WordCount> wordList = wordMap.entrySet().stream().map(e -> new WordCount(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
		return Response.ok(wordList).build();
	}
}
