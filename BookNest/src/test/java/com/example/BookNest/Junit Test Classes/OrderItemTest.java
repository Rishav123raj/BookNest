package com.example.BookNest.JunitTestClasses;
import com.example.BookNest.model.OrderItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;   

@SpringBootTest
public class OrderItemTest {
@Test
public void testOrderItemGettersAndSetters() {
    OrderItem item = new OrderItem();
    item.setId(1L);
    item.setBookName("Test Book");
    item.setQuantity(3);

    assertEquals(1L, item.getId());
    assertEquals("Test Book", item.getBookName());
    assertEquals(3, item.getQuantity());
}

}