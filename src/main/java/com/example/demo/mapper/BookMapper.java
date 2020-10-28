package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;

@Component
public class BookMapper {

  public Book mapRow(BookDTO bookDto) {
    return new Book(bookDto.getId(), bookDto.getName(), bookDto.getIsbn(), bookDto.getAuthorName(),
        bookDto.getAuthorCountry(), bookDto.getCategory(), bookDto.getPrice(), bookDto.getAvailableCount(),
        bookDto.getSoldOut(), null, null);
  }

}
