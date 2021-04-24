package com.example.C868CapstoneProject.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT b FROM Book b WHERE b.isbn = ?1")
	Optional<Book> findBookByISBN(Long isbn);
}
