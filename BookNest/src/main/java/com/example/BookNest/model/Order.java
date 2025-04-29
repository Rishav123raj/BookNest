package com.example.BookNest.model;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Order {
    @Id @GeneratedValue private Long id;
    private Long userId;
    private String shippingAddress;
    private String paymentDetails;
    private LocalDateTime orderDate;
}
