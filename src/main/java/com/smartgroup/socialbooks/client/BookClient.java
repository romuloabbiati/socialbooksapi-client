package com.smartgroup.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.smartgroup.socialbooks.client.domain.Book;

public class BookClient {

	public List<Book> findAll() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/books"))
				.header("Authorization", "Basic cm9tdWxvYWJiaWF0aTpzM25oNA==")
				.build();
		
		ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String save(Book book) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Book> request = RequestEntity
				.post(URI.create("http://localhost:8080/books"))
				.header("Authorization", "Basic cm9tdWxvYWJiaWF0aTpzM25oNA==")
				.body(book);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
}
