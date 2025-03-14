package com.restaurant.repositories;

import com.restaurant.models.Cart;
import com.restaurant.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.user = :user AND c.isCheckedOut = false ORDER BY c.id DESC")
    Optional<Cart> findLatestActiveCart(@Param("user") User user);
}
