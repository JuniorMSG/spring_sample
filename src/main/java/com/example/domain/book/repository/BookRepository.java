package com.example.domain.book.repository;

import com.example.domain.book.entity.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    List<Book> findByAuthor(String author);
    List<Book> findByTitleContaining(String keyword);
    void deleteById(Long id);
    boolean existsByIsbn(String isbn);

    boolean existsById(Long id);
}