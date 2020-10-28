package com.backend.bookStore.controller;

import com.backend.bookStore.entity.BookEntity;
import com.backend.bookStore.model.BookRequest;
import com.backend.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(path = "/getAll")

    public ResponseEntity<List<BookEntity>> getAllBooks(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize
    ) {
        try {
            List<BookEntity> books = bookService.getAllBooks(pageNo, pageSize);
            System.out.println(books);
            return ResponseEntity.ok().body(books);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    
    @GetMapping(path = "/getBooksData")
    public ResponseEntity<Integer> getCountOfBooks() {
        try {
            int noOfBooks = bookService.getCountOfBooks();
            return ResponseEntity.ok().body(noOfBooks);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


    @GetMapping(path = "/hello")
    public ResponseEntity<String> checkAccount() {
        return ResponseEntity.ok().body("String");
    }

    @GetMapping(path = "/searchBook")
    public ResponseEntity<List<BookEntity>> searchBook() {
        try {
            List<BookEntity> bookData = bookService.getAllBooks();
            return ResponseEntity.ok().body(bookData);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(path = "/save/books")
    public ResponseEntity<Boolean> saveBooks(@RequestBody BookRequest request) {
        try {
            System.out.println(request);
            BookEntity data = bookService.saveBook(request);
            if (data != null) {
                return ResponseEntity.ok().body(Boolean.TRUE);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(path = "/save/booksAll")
    public ResponseEntity<Boolean> saveAllBooks(@RequestBody List<BookRequest> request) {
        try {
            BookEntity data=new BookEntity();
            for(int i=0;i<request.size();i++) {
                data = bookService.saveBook(request.get(i));
            }
            if (data != null) {
                return ResponseEntity.ok().body(Boolean.TRUE);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(path = "/books/quantity")
    public ResponseEntity<Boolean> updateQuantity(
            @RequestParam("id") Integer id,
            @RequestParam("quantity") Integer quantity) {
        try {
            int service = bookService.updateQuantity(id, quantity);
            return ResponseEntity.ok().build();
        } catch (ArithmeticException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
