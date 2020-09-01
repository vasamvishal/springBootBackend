package com.backend.bookStore.controller;

import com.backend.bookStore.entity.BookEntity;
import com.backend.bookStore.model.BookRequest;
import com.backend.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
            return ResponseEntity.ok().body(books);
        } catch (Exception e) {
            System.out.println("EException" + e);
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(path = "/save/books")
    public ResponseEntity<Boolean> saveBooks(@RequestBody BookRequest request) {
        try {
            BookEntity data = bookService.saveBook(request);
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
            System.out.println("id" + id);
            System.out.println("id" + quantity);
            int service = bookService.updateQuantity(id, quantity);
            System.out.println(service);
            return ResponseEntity.ok().build();
//            } else {
//                return ResponseEntity.notFound().build();
//            }
        } catch (ArithmeticException e) {
            System.out.println(e);
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            System.out.println(e);
            return ResponseEntity.status(500).build();
        }
    }
}
