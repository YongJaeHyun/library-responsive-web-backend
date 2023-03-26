package com.book24.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.book24.library.domain.BookEntity;
import com.book24.library.dto.BookDTO;
import com.book24.library.service.BookService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*") // CORS 문제 해결
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	private final BookService bookService;

	@GetMapping("/get/book/recent")
	public ResponseEntity<?> getRecent10Books() {
		try {
			List<BookEntity> entity = bookService.getRecent10Books();
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/get/book/all")
	public ResponseEntity<?> getAllBooks() {
		try {
			List<BookEntity> entity = bookService.getAllBooks();
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/get/book/book_id")
	public ResponseEntity<?> getBookByBook_id(@RequestParam("book_id") Long book_id) {
		try {
			BookEntity entity = bookService.getBookByBook_id(book_id);
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/get/book/nation")
	public ResponseEntity<?> getBookByCategory(@RequestParam("nation") String nation) {
		try {
			List<BookEntity> entity = bookService.getBookByNation(nation);
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/get/book/genre")
	public ResponseEntity<?> getBookByGenre(@RequestParam("genre") String genre) {
		try {
			List<BookEntity> entity = bookService.getBookByGenre(genre);
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/get/book/nation+genre")
	public ResponseEntity<?> getBookByCategoryAndGenre(@RequestParam("nation") String nation, @RequestParam("genre") String genre) {
		try {
			List<BookEntity> entity = bookService.getBookByNationAndGenre(nation, genre);
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/search/book/title")
	public ResponseEntity<?> searchBookAll(@RequestParam("title") String title) {
		try {
			List<BookEntity> entity = bookService.searchBookByTitle(title);
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/search/book/category")
	public ResponseEntity<?> searchBookByCategory(@RequestParam("category") String category) {
		try {
			List<BookEntity> entity = bookService.searchBookByCategory(category);
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}
	
	@GetMapping("/search/book/price/less")
	public ResponseEntity<?> searchBookLessThanPrice(@RequestParam("price") Integer price) {
		try {
			List<BookEntity> entity = bookService.searchBookLessThanPrice(price);
			return ResponseEntity.ok(entity);
 		} catch (RuntimeException e){
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Server Error");
 		}
	}

	@PostMapping("/insert/book")
	public ResponseEntity<?> insertBook(@RequestBody BookDTO dto) {
		try {
			BookEntity entity = dto.toEntity();
			bookService.insert(entity);
			return ResponseEntity.ok(null);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insert Error");
		}
	}

	@PutMapping("/update/book/{book_id}")
	public ResponseEntity<?> updateBook(@PathVariable Long book_id, @RequestBody BookDTO dto) {
		try {
			BookEntity entity = dto.toEntity();
			bookService.update(book_id, entity);
			return ResponseEntity.ok(null);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insert Error");
		}
	}
	
	@DeleteMapping("/delete/book/{book_id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long book_id) {
		try {
			bookService.delete(book_id);
			return ResponseEntity.ok(null);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insert Error");
		}
	}
}
