package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.apis.Main;
import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.service.MainService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookApiTest {

  @InjectMocks
  Main main;

  @Mock
  MainService mainService;

  BookDTO bookDto = new BookDTO(null, "test", "1000", "jemilan", "India", null, 1003, 0, false, null, null);
  Book book = new Book(1, "test", "1000", "jemilan", "India", null, 1003, 0, false, null, null);

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void addBookTest() throws Exception {
    when(mainService.addBook(bookDto)).thenReturn(book);
    String bookDtoString = objectMapper.writeValueAsString(bookDto);
    mockMvc.perform(
        post("/book").contentType(MediaType.APPLICATION_JSON).content(bookDtoString).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();
  }

  @Test
  void getBookTest() {
    get("/book/test").equals(bookDto);
    when(mainService.getBook("test")).thenReturn(book);
  }

  @Test
  void putBookTest() {
  }

}
