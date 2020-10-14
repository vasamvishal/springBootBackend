package com.backend.bookStore.service;

import com.backend.bookStore.entity.BookEntity;
import com.backend.bookStore.model.BookRequest;
import com.backend.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        List<BookEntity> allBooks = bookRepository.findAll();
        return allBooks;
    }

    public BookEntity saveBook(BookRequest request) {
        BookEntity entity = request.toEntity(request);
        return bookRepository.save(entity);
    }

    public int updateQuantity(Integer id, Integer quantity) {
        Optional<BookEntity> BookRepository = bookRepository.findById(id);
        if (!BookRepository.isPresent()) {
            throw new ArithmeticException("not found" + id);
        } else {
            return bookRepository.updateQuantity(id, quantity);
        }
    }
}
