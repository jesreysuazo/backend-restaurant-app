package com.restaurant.services;

import com.restaurant.models.*;
import com.restaurant.repositories.CartRepository;
import com.restaurant.repositories.OrderRepository;
import com.restaurant.repositories.UserRepository;
import com.restaurant.security.JwtProvider;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(CartRepository cartRepository, OrderRepository orderRepository, JwtProvider jwtProvider, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    //set status to APPROVED
    public Order approveOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(OrderStatus.APPROVED);
        order.setDateUpdated(LocalDateTime.now());

        // add 30 minutes fromapproval date
        order.setEta(order.getDateUpdated().plusMinutes(30));

        return orderRepository.save(order);
    }

    //set status to REJECTED
    public Order rejectOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(OrderStatus.REJECTED);
        order.setDateUpdated(LocalDateTime.now());

        return orderRepository.save(order);
    }

    public Order cancelOrder(String token, Long orderId) {
        Long userId = jwtProvider.getIdFromToken(token.substring(7));

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        //checker for user cancelling the order
        if (!order.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized: You can only cancel your own orders");
        }

        order.setStatus(OrderStatus.CANCELLED);
        order.setDateUpdated(LocalDateTime.now());

        return orderRepository.save(order);
    }

    public List<Order> getOrders(String token) {
        Long userId = jwtProvider.getIdFromToken(token.substring(7));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() == Role.ADMIN) {
            List<Order> orders = orderRepository.findAll();
            orders.forEach(order -> {
                User orderUser = userRepository.findById(order.getUserId()).orElse(null);
                if (orderUser != null) {
                    order.setContactNumber(orderUser.getPhoneNumber());
                    order.setAddress(orderUser.getAddress());
                    order.setName(orderUser.getName());
                }
            });
            return orders;
        }

        List<Order> userOrders = orderRepository.findByUserId(userId);
        userOrders.forEach(order -> {
            order.setName(user.getName());
            order.setContactNumber(user.getPhoneNumber());
            order.setAddress(user.getAddress());
        });

        return userOrders;
    }

    public Order getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        // checker if ETA past the approve time. set to completed
        if (order.getEta() != null && order.getEta().isBefore(LocalDateTime.now()) && order.getStatus() != OrderStatus.COMPLETED) {
            order.setStatus(OrderStatus.COMPLETED);
            order.setDateUpdated(LocalDateTime.now());
            orderRepository.save(order);
        }

        return order;
    }

    @Transactional
    public Order checkout(String token, Long cartId) {
        Long userId = jwtProvider.getIdFromToken(token.substring(7));

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        if (!cart.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Unauthorized checkout attempt");
        }

        if (cart.isCheckedOut()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This cart has already been checked out");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setProductIds(cart.getProducts().stream().map(Product::getId).toList());
        order.setTotalPrice(cart.getTotalPrice());
        order.setDateCreated(LocalDateTime.now());
        order.setDateUpdated(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        Order savedOrder = orderRepository.save(order);

        cart.setCheckedOut(true);
        cart.setCheckedOutDate(LocalDateTime.now());
        cartRepository.save(cart);

        return savedOrder;
    }

}