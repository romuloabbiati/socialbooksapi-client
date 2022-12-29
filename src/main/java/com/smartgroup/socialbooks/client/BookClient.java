package com.smartgroup.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.smartgroup.socialbooks.client.domain.Book;

public class BookClient {
	
	private RestTemplate restTemplate;
	
	private String URI_BASE;
	
	private String URN_BASE = "/books";
	
	private String credential;
	
	public BookClient(String url, String user, String password) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
		
		String credentialAux = user + ":" + password;
		
		credential = "Basic " + Base64.getEncoder()
			.encodeToString(credentialAux.getBytes());
	}

	public List<Book> findAll() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/books"))
				.header("Authorization", credential)
				.build();
		
		ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String save(Book book) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Book> request = RequestEntity
				.post(URI.create("http://localhost:8080/books"))
				.header("Authorization", credential)
				.body(book);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	public Book findABook(String uri) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credential)
				.build();
		
		ResponseEntity<Book> response = restTemplate.exchange(request, Book.class);
		
		return response.getBody();
	}
	
}
