package com.backend.bookStore.controller;

import com.backend.bookStore.entity.CartEntity;
import com.backend.bookStore.model.CartRequest;
import com.backend.bookStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping (path = "/post/cart")
    public ResponseEntity<CartEntity> setCartDetails(@RequestBody CartRequest cartRequest){

        try {
            CartEntity data = cartService.setCart(cartRequest);
            if (data != null) {
                return ResponseEntity.ok().body(cartService.setCart(cartRequest));
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(path = "/get/cart")
    public ResponseEntity<List<CartEntity>> getCartDetails(){
        return ResponseEntity.ok().body(cartService.getCartDetails());
//      return cartService.getCartDetails();
    }

    @DeleteMapping(path = "/delete/{phoneNumber}/{_id}")
    public ResponseEntity<Object> deleteCartDetails(@PathVariable String phoneNumber,@PathVariable String _id ){
      try {
          cartService.deleteCartDetails(phoneNumber, _id);
          return ResponseEntity.ok().build();
      }
      catch (ArithmeticException e){
          return ResponseEntity.badRequest().body(e);
      }
      catch (RuntimeException e) {
          return ResponseEntity.status(500).body(e);
      }
    }
}
