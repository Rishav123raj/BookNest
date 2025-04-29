package com.example.BookNest.service;
import com.example.BookNest.model.BookItem;
import com.example.BookNest.repository.BookItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookItemService {
@Autowired
private BookItemRepository bookItemRepository;

public BookItem saveBookItem(BookItem bookItem) {
    return bookItemRepository.save(bookItem);
}

public List<BookItem> getAllBookItems() {
    return bookItemRepository.findAll();
}

public BookItem getBookItemById(Long id) {
    return bookItemRepository.findById(id).orElse(null);
}

public void deleteBookItem(Long id) {
    bookItemRepository.deleteById(id);
}

}