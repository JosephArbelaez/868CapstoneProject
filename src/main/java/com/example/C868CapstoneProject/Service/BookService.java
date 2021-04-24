package com.example.C868CapstoneProject.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.C868CapstoneProject.Repository.BookRepository;
import com.example.C868CapstoneProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
		
	private final BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getBooks() {
			return bookRepository.findAll();
	}
	
	public void postBook(Book book) {
		Optional<Book> bookOptional = bookRepository.findBookByISBN(book.getIsbn());
		
		if(bookOptional.isPresent()) {
			throw new IllegalStateException("Book is present");
		} else {
			bookRepository.save(book);	
			
		}
	}

	public void deleteBook(Long isbn) {
		boolean exists = bookRepository.existsById(isbn);
		
		if(!exists) {
			throw new IllegalStateException("ISBN " + isbn + " does not exist.");
		}
		
		bookRepository.deleteById(isbn);
	}

	@Transactional
	public void updateBook(Long isbn, String title, String genre) {
		Book book = bookRepository.findBookByISBN(isbn).orElseThrow(
				() -> new IllegalStateException (
						"Book with ISBN " +
						isbn +
						" does not exist."));
		
		if (title != null &&
				title.length() > 0 &&
				!Objects.equals(book.getTitle(), title)) {
			book.setTitle(title);
		}
		
		if (genre != null &&
				genre.length() > 0 &&
				!Objects.equals(book.getGenre(), genre)) {
			book.setGenre(genre);
		}
	}
	
}
