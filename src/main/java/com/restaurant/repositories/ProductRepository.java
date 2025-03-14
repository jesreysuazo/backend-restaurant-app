package com.restaurant.repositories;

import com.restaurant.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //active products
    List<Product> findByStatus(int status);

    // all products (including deleted)
    List<Product> findAll();
}
