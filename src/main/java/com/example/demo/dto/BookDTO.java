package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.example.demo.entity.Catogory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/**
 * 
 * The Entity class that has the book details
 * 
 */
public class BookDTO {

  private Integer id;

  private String name;

  private String isbn;

  private String authorName;

  private String authorCountry;

  private Set<Catogory> category;

  private Integer price;

  private Integer availableCount;

  private Boolean soldOut;

  private LocalDateTime addedDate;

  private LocalDateTime soldOutDate;

}
