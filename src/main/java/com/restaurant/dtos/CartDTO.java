package com.restaurant.dtos;

import com.restaurant.models.Cart;
import java.util.List;
import java.util.stream.Collectors;

public class CartDTO {
    private Long id;
    private UserDTO user;
    private List<ProductDTO> products;
    private Double totalPrice;

    public CartDTO(Cart cart) {
        this.id = cart.getId();
        this.user = new UserDTO(cart.getUser().getId(), cart.getUser().getName(),
                cart.getUser().getEmail(), cart.getUser().getRole());

        // return of fetched data
        this.products = cart.getProducts().stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getCategory()
                )).collect(Collectors.toList());

        this.totalPrice = cart.getTotalPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
