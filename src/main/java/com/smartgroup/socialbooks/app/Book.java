package com.smartgroup.socialbooks.app;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
	
	private Long id;

	private String name;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date release;
	
	private String publisher;
	
	private String summary;
	
	private List<Comment> comments;
	
	private Author author;
	
	public Book() {}
	
	public Book(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getRelease() {
		return release;
	}
	
	public void setRelease(Date release) {
		this.release = release;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
