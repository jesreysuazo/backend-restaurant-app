package com.restaurant.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ElementCollection
    private List<Long> productIds;

    private double totalPrice;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime eta;  // Estimated Time of Arrival (null until approved)

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String contactNumber;
    private String address;
    private String name;

    public Order() {}

    public Order(Long userId, List<Long> productIds, double totalPrice, LocalDateTime dateCreated,
                 LocalDateTime dateUpdated, LocalDateTime eta, OrderStatus status, String contactNumber, String address, String name) {
        this.userId = userId;
        this.productIds = productIds;
        this.totalPrice = totalPrice;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.eta = eta;
        this.status = status;
        this.contactNumber = contactNumber;
        this.address = address;
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public List<Long> getProductIds() { return productIds; }
    public void setProductIds(List<Long> productIds) { this.productIds = productIds; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public LocalDateTime getDateCreated() { return dateCreated; }
    public void setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }

    public LocalDateTime getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }

    public LocalDateTime getEta() { return eta; }
    public void setEta(LocalDateTime eta) { this.eta = eta; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
