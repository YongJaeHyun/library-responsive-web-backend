package com.book24.library.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@SequenceGenerator(name = "BOOK_SEQ_GENERATOR", sequenceName = "BOOK_SEQUENCE", initialValue = 1, allocationSize = 1)
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ_GENERATOR")
	private Long book_id;
	private String title;
	private String writer;
	private String category;
	private String nation;
	private String genre;
	private Integer price;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date insert_date;
}
