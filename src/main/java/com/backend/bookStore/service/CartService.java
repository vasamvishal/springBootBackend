package com.backend.bookStore.service;

import com.backend.bookStore.entity.CartEntity;
import com.backend.bookStore.model.CartRequest;
import com.backend.bookStore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public CartEntity setCart(CartRequest cartRequest) {
        CartEntity cartEntity = cartRequest.toEntity(cartRequest);
        System.out.println("SSS" + cartEntity.toString());
        return cartRepository.save(cartEntity);
    }

    public List<CartEntity> getCartDetails() {
        return cartRepository.findAll();
    }

    public void deleteCartDetails(String phoneNumber, String _id) {
        List<CartEntity> cartEntities = cartRepository.findByname(phoneNumber);
        if (cartEntities.size() > 0) {
            List<CartEntity> cartEntities1 = cartRepository.findByID(_id);
            if (cartEntities1.size() > 0) {
                cartRepository.delete(phoneNumber, _id);
            } else {
                throw new ArithmeticException("ID is not found");
            }
        } else {
            throw new ArithmeticException("phone number is not found");
        }
    }
}
