package com.example.BookNest.JunitTestClasses;
import com.example.BookNest.controller.BookController;
import com.example.BookNest.model.BookItem;
import com.example.BookNest.service.BookItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class BookControllerTest {
@Mock
private BookItemService bookItemService;

@InjectMocks
private BookController bookController;

@Test
public void testGetAllBooks() {
    BookItem book1 = new BookItem(1L, "Java Book", "John", 10);
    BookItem book2 = new BookItem(2L, "Python Book", "Doe", 5);

    when(bookItemService.getAllBookItems()).thenReturn(Arrays.asList(book1, book2));

    ResponseEntity<List<BookItem>> response = bookController.getAllBooks();

    assertEquals(200, response.getStatusCodeValue());
    assertEquals(2, response.getBody().size());
    verify(bookItemService, times(1)).getAllBookItems();
}
}