package com.restaurant.controllers;

import com.restaurant.dtos.CheckoutRequest;
import com.restaurant.models.Order;
import com.restaurant.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(@RequestHeader("Authorization") String token) {
        List<Order> orders = orderService.getOrders(token);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestHeader("Authorization") String token,
                                          @RequestBody CheckoutRequest checkoutRequest) {
        Order order = orderService.checkout(token, checkoutRequest.getCartId());
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/{orderId}/approve")
    public Order approveOrder(@PathVariable Long orderId) {
        return orderService.approveOrder(orderId);
    }

    @PostMapping("/{orderId}/reject")
    public Order rejectOrder(@PathVariable Long orderId) {
        return orderService.rejectOrder(orderId);
    }

    @PostMapping("/{orderId}/cancel")
    public Order cancelOrder(@RequestHeader("Authorization") String token,@PathVariable Long orderId) {
        return orderService.cancelOrder(token,orderId);
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
}