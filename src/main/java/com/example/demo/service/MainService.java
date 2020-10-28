package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.exception.ValidationException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repositroy.BookRepository;

@Service
public class MainService {

  @Autowired
  BookRepository bookRepository;

  @Autowired
  BookMapper bookMapper;

  public Book addBook(BookDTO book) {
    return bookRepository.save(bookMapper.mapRow(book));
  }

  @Cacheable("book")
  public Book getBook(String id) {
    return bookRepository.findByName(id);
  }

  public Book putBook(BookDTO book) {
    if (Objects.nonNull(book.getId()))
      return bookRepository.save(bookMapper.mapRow(book));
    else
      throw new ValidationException("Id is incorrect");
  }

}
