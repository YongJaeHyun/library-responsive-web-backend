package com.book24.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book24.library.domain.BookEntity;
import com.book24.library.persistence.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	
	public BookEntity getBookByBook_id(final Long book_id) {
		return repository.getBookByBook_id(book_id);
	}
	
	public List<BookEntity> getBookByNation(final String nation) {
		return repository.getBookByNation(nation);
	}
	
	public List<BookEntity> getBookByGenre(final String genre) {
		return repository.getBookByGenre(genre);
	}
	
	public List<BookEntity> getBookByNationAndGenre(final String nation, final String genre) {
		return repository.getBookByNationAndGenre(nation, genre);
	}
	
	public List<BookEntity> searchBookByTitle(final String title) {
		return repository.searchBookByTitle(title);
	}
	
	public List<BookEntity> searchBookByCategory(final String category) {
		return repository.searchBookByCategory(category);
	}
	
	public List<BookEntity> searchBookLessThanPrice(final Integer price) {
		return repository.searchBookLessThanPrice(price);
	}

	public List<BookEntity> getAllBooks() {
		return repository.findAll();
	}

	public List<BookEntity> getRecent10Books() {
		return repository.getRecent10Books();
	}

	public void insert(final BookEntity entity) {
		repository.save(entity);
	}
	
	public void update(final Long book_id, final BookEntity entity) {
		entity.setBook_id(book_id);
		entity.setInsert_date(new Date());
		repository.save(entity);
	}
	
	public void delete(final Long book_id) {
		repository.deleteById(book_id);
	}
}
