package com.smartgroup.socialbooks.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.smartgroup.socialbooks.client.BookClient;
import com.smartgroup.socialbooks.client.domain.Book;

public class App {

	public static void main(String[] args) throws ParseException {
		
		BookClient client = new BookClient(
				"http://localhost:8080", "romuloabbiati", "s3nh4");
		
		List<Book> booksList = client.findAll();
		
		for(Book book : booksList) {
			System.out.println("Book: " + book.getName());
		}
		
		
		Book book = new Book();
		book.setName("REST Hands On");
		book.setPublisher("MAKRON Books");
		
		SimpleDateFormat releaseDate = new SimpleDateFormat("dd/MM/yyyy");
		book.setRelease(releaseDate.parse("01/01/2023"));
		
		book.setSummary("This book will teach you how to create REST APIs");
		
		String location = client.save(book);
		
		System.out.println("Book URI: " + location);
	}
	
}
