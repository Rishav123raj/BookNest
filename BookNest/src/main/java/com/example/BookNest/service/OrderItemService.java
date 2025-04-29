package com.example.BookNest.service;
import com.example.BookNest.model.CartItem;
import com.example.BookNest.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderItemService{
@Autowired
private CartItemRepository cartItemRepository;

public CartItem saveCartItem(CartItem cartItem) {
    return cartItemRepository.save(cartItem);
}

public List<CartItem> getAllCartItems() {
    return cartItemRepository.findAll();
}

public CartItem getCartItemById(Long id) {
    return cartItemRepository.findById(id).orElse(null);
}

public void deleteCartItem(Long id) {
    cartItemRepository.deleteById(id);
}
}