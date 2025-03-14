package com.restaurant.services;

import com.restaurant.models.Cart;
import com.restaurant.models.Product;
import com.restaurant.models.User;
import com.restaurant.repositories.CartRepository;
import com.restaurant.repositories.ProductRepository;
import com.restaurant.repositories.UserRepository;
import com.restaurant.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;


    public Cart addToCart(String token, List<Long> productIds) {
        token = token.substring(7);
        Long userId = jwtProvider.getIdFromToken(token);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        //fetch latest nonchecked out cart
        Cart cart = cartRepository.findLatestActiveCart(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        List<Product> products = productRepository.findAllById(productIds);

        if (cart.getProducts() == null) {
            cart.setProducts(new ArrayList<>());
        }

        cart.getProducts().addAll(products);
        cart.setTotalPrice(calculateTotalPrice(cart.getProducts()));

        return cartRepository.save(cart);
    }


    //remove products
    public Cart editCart(String token, List<Long> productIdsToRemove) {
        token = token.substring(7);
        Long userId = jwtProvider.getIdFromToken(token);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        //Fetch the latest non-checked-out cart
        Cart cart = cartRepository.findLatestActiveCart(user)
                .orElseThrow(() -> new RuntimeException("No active cart found"));

        cart.getProducts().removeIf(product -> productIdsToRemove.contains(product.getId()));
        cart.setTotalPrice(calculateTotalPrice(cart.getProducts()));

        return cartRepository.save(cart);
    }


    public Cart viewCart(String token) {
        token = token.substring(7);
        Long userId = jwtProvider.getIdFromToken(token);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepository.findLatestActiveCart(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    newCart.setProducts(new ArrayList<>());
                    newCart.setTotalPrice(0.0);
                    return cartRepository.save(newCart);
                });
    }


    private double calculateTotalPrice(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}