package com.example.infrastructure.persistence;

import com.example.domain.book.entity.Book;
import com.example.domain.book.repository.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryImpl extends BookRepository, JpaRepository<Book, Long> {
    // JpaRepository에서 기본 메서드 제공
}