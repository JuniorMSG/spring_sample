package com.example.application.dto.book;

import com.example.domain.book.entity.Book;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private int publicationYear;

    public static BookResponse from(Book book) {
        return BookResponse
                .builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .isbn(book.getIsbn())
                .publicationYear(book.getPublicationYear())
                .build();
    }
}