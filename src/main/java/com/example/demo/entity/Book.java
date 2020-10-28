package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "isbn" }))
/**
 * 
 * The Entity class that has the book details
 * 
 */
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String isbn;

  private String authorName;

  private String authorCountry;

  @ManyToMany
  private Set<Catogory> category;

  private Integer price;

  private Integer availableCount;

  private Boolean soldOut;

  private LocalDateTime addedDate;

  private LocalDateTime soldOutDate;

}
