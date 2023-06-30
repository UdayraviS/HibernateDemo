package com.cruds.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author 
{
	@Id
	@GeneratedValue
	@Column(name = "author_id")
	private long id;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 30, nullable = false)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_author", joinColumns = {
	@JoinColumn(name = "book_id")}, inverseJoinColumns = {
	@JoinColumn(name = "author_id")		
	})
	public Set<Book> books;
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Author(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	
	
	
	
}
