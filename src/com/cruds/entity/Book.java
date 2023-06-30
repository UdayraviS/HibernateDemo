package com.cruds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book 
{
	@Id
	@Column(name = "book_id")
	@GeneratedValue
	private long id;
	
	@Column(name = "isbn")
	private String ISBN;
	
	@Column(length = 30, nullable = false)
	private String title;
	
	@Column(length = 30, nullable = false)
	private String category;
	
	@Column(name = "no_of_books", length = 2, nullable = false)
	private int noOfBooks;

	//private Author author;  
	
	
	
	/*public Book(String iSBN, String title, String category, int noOfBooks, Author author) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
		this.noOfBooks = noOfBooks;
		this.author = author;
	}*/
	
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Book(String iSBN, String title, String category, int noOfBooks) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
		this.noOfBooks = noOfBooks;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}



	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", noOfBooks=" + noOfBooks + "]";
	}

	/*@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", noOfBooks=" + noOfBooks
				+ ", author=" + author + "]";
	}*/

	
}
