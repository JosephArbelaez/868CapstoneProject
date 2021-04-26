package com.example.C868CapstoneProject.Controller;

import java.util.List;

import com.example.C868CapstoneProject.Service.BookService;
import com.example.C868CapstoneProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/book")
@CrossOrigin("*")
public class BookController {
	
		private final BookService bookService;
		
		@Autowired
		public BookController(BookService bookService) {
			this.bookService = bookService;
		}
		
		@GetMapping
		public List<Book> getBooks() {
			return bookService.getBooks();
		}
		
		@PostMapping
		public void postBook(@RequestBody Book book) {
			bookService.postBook(book);
		}
		
		@DeleteMapping(path = "{isbn}")
		public void deleteBook(@PathVariable("isbn") Long isbn) {
			bookService.deleteBook(isbn);
		}
		
		@PutMapping(path = "{isbn}")
		public void updateBook(
				@PathVariable("isbn") Long isbn,
				@RequestParam(required = false) String title,
				@RequestParam(required = false) String genre) {
			bookService.updateBook(isbn, title, genre);
		}
		
	}
