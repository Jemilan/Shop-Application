package com.example.demo.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.service.MainService;
import com.example.demo.utils.Constants;

@RestController
@RequestMapping("/book")
public class Main {

  @Autowired
  MainService mainService;

  @GetMapping
  public String test() {

    return "test";
  }

  @PostMapping
  public String addBook(@RequestBody BookDTO book) {
    return Constants.BOOK_ADDED + mainService.addBook(book);
  }

  @GetMapping("/{name}")
  public Book getBook(@PathVariable(value = "name") String name) {
    return mainService.getBook(name);
  }

  @PutMapping
  public String putBook(@RequestBody BookDTO book) {
    return Constants.BOOK_UPDATED + mainService.putBook(book);
  }
}
