package com.example.C868CapstoneProject.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Book")
public class Book {
	
	@Id
	@Column(
		name = "isbn",
		updatable = false
	)
	private Long isbn;
	
	@Column(
			name = "title",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String title;
	
	@Column(
			name = "author",
			nullable = true,
			columnDefinition = "TEXT"
	)
	private String author;
	
	@Column(
			name = "description",
			nullable = true,
			columnDefinition = "TEXT"
	)
	private String description;
	
	@Column(
			name = "pageCount",
			nullable = true,
			columnDefinition = "INTEGER"
	)
	private int pageCount;
	
	@Column(
			name = "price",
			nullable = true,
			columnDefinition = "DECIMAL(5, 2)"
	)
	private double price;
	
	@Column(
			name = "genre",
			nullable = true,
			columnDefinition = "TEXT"
	)
	private String genre;

	@Column(
			name = "status",
			nullable = true,
			columnDefinition = "TEXT"
	)
	private String status;

	@Column(
			name = "url",
			nullable = true,
			columnDefinition = "TEXT"
	)
	private String url;

	@Column (
			name = "checkoutDate",
			nullable = true,
			columnDefinition = "DATE"
	)
	private LocalDate checkoutDate;

	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Book () {
		
	}
	public Book(Long isbn, String title, String author, String description, int pageCount, double price, String genre,
				String status) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.pageCount = pageCount;
		this.price = price;
		this.genre = genre;
		this.status = status;
		this.checkoutDate = null;
	}
	public Book(Long isbn, String title, String author, String description, int pageCount, double price, String genre,
			String status, String url) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.pageCount = pageCount;
		this.price = price;
		this.genre = genre;
		this.status = status;
		this.url = url;
		this.checkoutDate = null;
	}

	public Book(Long isbn, String title, String author, String description, int pageCount, double price, String genre,
				String status, String url, LocalDate checkoutDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.pageCount = pageCount;
		this.price = price;
		this.genre = genre;
		this.status = status;
		this.url = url;
		this.checkoutDate = checkoutDate;
	}

	public Book(Long isbn, String title, String author, String description, int pageCount, double price, String genre, String status, String url,Person p) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.pageCount = pageCount;
		this.price = price;
		this.genre = genre;
		this.status = status;
		this.person = p;
		this.url = url;
		this.checkoutDate = null;
	}



	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
}
