package com.backend.bookStore.repository;

import com.backend.bookStore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    @Transactional
    @Modifying
    @Query("update BookEntity c set c.quantity = :quantity WHERE c.id = :id")
    int updateQuantity(@Param("id") Integer id, @Param("quantity") Integer quantity);

    @Query("select count(id) from BookEntity")
    int getCountOfBooks();

    @Query("select b from BookEntity b")
    List<BookEntity> searchBook(@Param("search") String search);
}
