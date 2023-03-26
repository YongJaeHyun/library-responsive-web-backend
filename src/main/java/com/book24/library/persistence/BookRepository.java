package com.book24.library.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book24.library.domain.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
	@Query(value = "SELECT * FROM BOOK ORDER BY insert_date DESC LIMIT 10", nativeQuery = true)
	List<BookEntity> getRecent10Books();
	
	@Query(value = "SELECT * FROM BOOK WHERE book_id = ?1", nativeQuery = true)
	BookEntity getBookByBook_id(Long book_id);
	
	@Query(value = "SELECT * FROM BOOK WHERE nation = ?1", nativeQuery = true)
	List<BookEntity> getBookByNation(String nation);
	
	@Query(value = "SELECT * FROM BOOK WHERE genre = ?1", nativeQuery = true)
	List<BookEntity> getBookByGenre(String genre);
	
	@Query(value = "SELECT * FROM BOOK WHERE nation = ?1 AND genre = ?2", nativeQuery = true)
	List<BookEntity> getBookByNationAndGenre(String nation, String genre);
	
	@Query(value = "SELECT * FROM BOOK WHERE title LIKE %?1%", nativeQuery = true)
	List<BookEntity> searchBookByTitle(String title);

	@Query(value = "SELECT * FROM BOOK WHERE category LIKE %?1%", nativeQuery = true)
	List<BookEntity> searchBookByCategory(String category);
	 
	@Query(value = "SELECT * FROM BOOK WHERE price <= ?1", nativeQuery = true)
	List<BookEntity> searchBookLessThanPrice(Integer price);
}
