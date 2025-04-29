package com.example.BookNest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private double price;
}
