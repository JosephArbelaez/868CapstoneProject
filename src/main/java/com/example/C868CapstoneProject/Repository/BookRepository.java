package com.example.C868CapstoneProject.Repository;

import java.util.List;
import java.util.Optional;

import com.example.C868CapstoneProject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT b FROM Book b WHERE b.isbn = ?1")
	Optional<Book> findBookByISBN(Long isbn);

	@Query("SELECT b FROM Book b WHERE b.title LIKE %?1%")
	List<Book> searchBooks(String query);

	@Query("SELECT b FROM Book b WHERE person_id IS NOT NULL")
    List<Book> findCheckedBooks();

	@Query("SELECT b FROM Book b WHERE person_id IS NULL")
	List<Book> findUncheckedBooks();
}
