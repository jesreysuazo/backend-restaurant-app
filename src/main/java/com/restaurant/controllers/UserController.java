package com.restaurant.controllers;

import com.restaurant.models.Role;
import com.restaurant.models.User;
import com.restaurant.services.UserService;
import com.restaurant.security.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    public UserController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String token) {
        Long userId = jwtProvider.getIdFromToken(token.substring(7));
        User user = userService.getUserById(userId);

        if (user.getRole() != Role.ADMIN) {
            return ResponseEntity.status(403).body("Access denied. Admins only.");
        }

        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        Long userId = jwtProvider.getIdFromToken(token.substring(7));
        User adminUser = userService.getUserById(userId);

        if (adminUser.getRole() != Role.ADMIN) {
            return ResponseEntity.status(403).body("Access denied. Admins only.");
        }

        userService.softDeleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> makeAdmin(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        Long userId = jwtProvider.getIdFromToken(token.substring(7));
        User adminUser = userService.getUserById(userId);

        if (adminUser.getRole() != Role.ADMIN) {
            return ResponseEntity.status(403).body("Access denied. Admins only.");
        }

        userService.makeAdmin(id);
        return ResponseEntity.ok("User promoted to admin successfully.");
    }

}