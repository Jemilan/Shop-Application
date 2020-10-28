package com.example.demo.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

  Book findByName(String id);

}
