package com.example.BookNest.controller;
import com.example.BookNest.model.CartItem;
import com.example.BookNest.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired private CartItemRepository cartRepo;

    @PostMapping("/add")
    public CartItem add(@RequestBody CartItem item) {
        return cartRepo.save(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> viewCart(@PathVariable Long userId) {
        return cartRepo.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        cartRepo.deleteById(id);
    }

    @PutMapping("/update")
    public CartItem update(@RequestBody CartItem item) {
        return cartRepo.save(item);
    }
}
