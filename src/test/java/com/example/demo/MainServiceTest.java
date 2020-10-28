package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.exception.ValidationException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repositroy.BookRepository;
import com.example.demo.service.MainService;

@SpringBootTest
public class MainServiceTest {

  @InjectMocks
  MainService mainService;

  @Mock
  BookRepository bookRepository;

  @Mock
  BookMapper bookMapper;

  BookDTO bookDto = new BookDTO(null, "test", "1000", "jemilan", "India", null, 1003, 0, false, null, null);
  BookDTO bookDto1 = new BookDTO(1, "test", "1000", "jemilan", "India", null, 1003, 0, false, null, null);
  Book book = new Book(1, "test", "1000", "jemilan", "India", null, 1003, 0, false, null, null);
  Book book1 = new Book(1, "test1", "1000", "jemilan", "India", null, 1003, 0, false, null, null);

  @Test
  void addBookTest() {
    when(bookMapper.mapRow(bookDto)).thenReturn(book);
    when(bookRepository.save(book)).thenReturn(book);
    assertEquals(book, mainService.addBook(bookDto));
  }

  @Test
  void getBookTest() {
    when(bookRepository.findByName("test")).thenReturn(book);
    assertEquals(book, mainService.getBook("test"));
  }

  @Test
  void putBookTest() {
    when(bookMapper.mapRow(bookDto1)).thenReturn(book);
    when(bookRepository.save(book)).thenReturn(book);
    assertEquals(book, mainService.putBook(bookDto1));
    when(bookRepository.findByName("test")).thenReturn(new Book());
    assertThrows(ValidationException.class, () -> mainService.putBook(bookDto));
  }
}
