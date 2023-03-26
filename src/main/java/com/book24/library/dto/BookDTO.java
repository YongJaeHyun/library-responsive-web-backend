package com.book24.library.dto;

import java.util.Date;

import com.book24.library.domain.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
	private Long book_id;
	private String title;
	private String writer;
	private String category;
	private String nation;
	private String genre;
	private Integer price;
	private Date insert_date = new Date();

	// Entity ===> DTO로 변경
	public BookDTO(final BookEntity entity) {
		this.book_id = entity.getBook_id();
		this.title = entity.getTitle();
		this.writer = entity.getWriter();
		this.category = entity.getCategory();
		this.nation = entity.getNation();
		this.genre = entity.getGenre();
		this.price = entity.getPrice();
		this.insert_date = entity.getInsert_date();
	}

	// DTO ===> Entity로 변경
	public BookEntity toEntity() {
		return BookEntity.builder().book_id(book_id).title(title).writer(writer).category(category).nation(nation)
				.genre(genre).price(price).insert_date(insert_date).build();
	}
}
