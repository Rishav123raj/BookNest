package com.example.BookNest.JunitTestClasses;

import com.example.BookNest.model.CartItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class CartItemTest {
    @Test
    public void testCartItemProperties() {
        CartItem item = new CartItem();
        item.setId(1L);
        item.setBookTitle("Clean Code");
        item.setQuantity(2);

        assertEquals(1L, item.getId());
        assertEquals("Clean Code", item.getBookTitle());
        assertEquals(2, item.getQuantity());
    }
}