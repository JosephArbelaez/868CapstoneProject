package com.example.C868CapstoneProject.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.C868CapstoneProject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT b FROM Book b WHERE b.isbn = ?1")
	Optional<Book> findBookByISBN(Long isbn);

	@Query("SELECT b FROM Book b WHERE b.genre = ?1")
	List<Book> findBooksByGenre(String genre);

	@Query("SELECT b FROM Book b WHERE b.title LIKE %:query%")
	List<Book> searchBooks(@Param("query")String query);

	@Query("SELECT b FROM Book b WHERE person_id IS NOT NULL")
    List<Book> findCheckedBooks();

	@Query("SELECT b FROM Book b WHERE person_id IS NULL")
	List<Book> findUncheckedBooks();

	@Query("SELECT b FROM Book b WHERE checkout_date < ?1")
	List<Book> getLateBooks(LocalDate date);
}
