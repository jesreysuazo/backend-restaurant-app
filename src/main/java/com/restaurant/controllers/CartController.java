package com.restaurant.controllers;

import com.restaurant.dtos.CartDTO;
import com.restaurant.models.Cart;
import com.restaurant.services.CartService;
import com.restaurant.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/add")
    public ResponseEntity<CartDTO> addToCart(@RequestHeader("Authorization") String token,
                                             @RequestBody List<Long> productIds) {
        Cart cart = cartService.addToCart(token, productIds);
        return ResponseEntity.ok(new CartDTO(cart));
    }


    @PostMapping("/edit")
    public ResponseEntity<CartDTO> editCart(@RequestHeader("Authorization") String token,
                                            @RequestBody List<Long> productIdsToRemove) {
        Cart cart = cartService.editCart(token, productIdsToRemove);
        return ResponseEntity.ok(new CartDTO(cart));
    }

    @GetMapping("/view")
    public ResponseEntity<CartDTO> viewCart(@RequestHeader("Authorization") String token) {
        Cart cart = cartService.viewCart(token);
        return ResponseEntity.ok(new CartDTO(cart));
    }
}
