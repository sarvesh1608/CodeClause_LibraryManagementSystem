package com.librarymanagement.library.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Integer bookId;
	
	private String title;
	
	private Integer numberOfCopies;
	
	private String authorName;
	
	private String publisherName;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, String title, Integer numberOfCopies, String author, String publisher) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.numberOfCopies = numberOfCopies;
		this.authorName = author;
		this.publisherName = publisher;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(Integer numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String author) {
		this.authorName = author;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisher) {
		this.publisherName = publisher;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", numberOfCopies=" + numberOfCopies + ", authorName="
				+ authorName + ", publisherName=" + publisherName + "]";
	}

	
}
