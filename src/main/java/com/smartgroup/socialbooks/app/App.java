package com.smartgroup.socialbooks.app;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class App {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/books"))
				.header("Authorization", "Basic cm9tdWxvYWJiaWF0aTpzM25oNA==")
				.build();
		
		ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);
		
		for(Book book : response.getBody()) {
			System.out.println("Book " + book.getName());
		}
		
	}
	
}
