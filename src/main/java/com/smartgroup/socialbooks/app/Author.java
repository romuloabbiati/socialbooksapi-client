package com.smartgroup.socialbooks.app;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Author {

	private Long id;
	
	private String name;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	private String nacionality;
	
	private List<Book> book;
	
	public Author() {}

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public List<Book> getBook() {
		return book;
	}
	
}
