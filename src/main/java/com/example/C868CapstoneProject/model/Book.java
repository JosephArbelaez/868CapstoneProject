package com.example.C868CapstoneProject.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.*;

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
	
	@Transient
	@Column(
			name = "status",
			nullable = true,
			columnDefinition = "BOOLEAN"
	)
	private boolean status;

	@ManyToOne
	@JoinColumn(name="patronID", nullable=true)
	private Patron patron;


	public Book () {
		
	}

	public Book(Long isbn, String title, String author, String description, int pageCount, double price, String genre,
			boolean status) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.pageCount = pageCount;
		this.price = price;
		this.genre = genre;
		this.status = status;
	}

	public Book(Long isbn, String title, String author, String description, int pageCount, double price, String genre,
				boolean status, Patron patron) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.pageCount = pageCount;
		this.price = price;
		this.genre = genre;
		this.status = status;
		this.patron = patron;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}
}
