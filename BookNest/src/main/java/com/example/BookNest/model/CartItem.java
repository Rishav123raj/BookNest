package com.example.BookNest.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class CartItem {
    @Id @GeneratedValue private Long id;

    private Long userId;
    private Long bookId;
    private int quantity;
}
