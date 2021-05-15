package com.example.C868CapstoneProject.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.C868CapstoneProject.Repository.BookRepository;
import com.example.C868CapstoneProject.model.Book;
import com.example.C868CapstoneProject.model.Patron;
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

	public List<Book> searchBooks(String query) {
		query = query.toLowerCase(Locale.ROOT);
		return bookRepository.searchBooks(query);
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
	public void updateBook(Book book) {
		Book bookTemp = bookRepository.findBookByISBN(book.getIsbn()).orElseThrow(
				() -> new IllegalStateException (
						"Book with ISBN " +
						book.getIsbn() +
						" does not exist."));
		
		if (book.getTitle() != null &&
				book.getTitle().length() > 0 &&
				!Objects.equals(bookTemp.getTitle(), book.getTitle())) {
			bookTemp.setTitle(book.getTitle());
		}
		if (book.getAuthor() != null &&
				book.getAuthor().length() > 0 &&
				!Objects.equals(bookTemp.getAuthor(), book.getAuthor())) {
			bookTemp.setAuthor(book.getAuthor());
		}

		if (book.getDescription() != null &&
				book.getDescription().length() > 0 &&
				!Objects.equals(bookTemp.getDescription(), book.getDescription())) {
			bookTemp.setDescription(book.getDescription());
		}

		if (book.getPageCount() > 0 &&
				!Objects.equals(bookTemp.getPageCount(), book.getPageCount())) {
			bookTemp.setPageCount(book.getPageCount());
		}

		if (book.getPrice() > 0 &&
				!Objects.equals(bookTemp.getPrice(), book.getPrice())) {
			bookTemp.setPageCount(book.getPageCount());
		}
		if (book.getGenre() != null &&
				book.getGenre().length() > 0 &&
				!Objects.equals(bookTemp.getGenre(), book.getGenre())) {
			bookTemp.setGenre(book.getGenre());
		}

		if (!Objects.equals(bookTemp.getStatus(), book.getStatus())) {
			bookTemp.setStatus(book.getStatus());
		}
		if (book.getUrl() != null &&
				book.getUrl().length() > 0 &&
				!Objects.equals(bookTemp.getUrl(), book.getUrl())) {
			bookTemp.setGenre(book.getUrl());
		}

		if (!Objects.equals(bookTemp.getPerson(), book.getPerson())) {
			bookTemp.setPerson(book.getPerson());
		}
	}

    public List<Book> getCheckedBooks() {
		return bookRepository.findCheckedBooks();
    }

	public List<Book> getUncheckedBooks() {
		return bookRepository.findUncheckedBooks();
	}
}
