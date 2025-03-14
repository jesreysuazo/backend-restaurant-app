package com.restaurant.controllers;

import com.restaurant.dtos.ProductDTO;
import com.restaurant.models.Product;
import com.restaurant.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) Integer status) {
        if (status != null) {
            return productService.getProductsByStatus(status);
        }
        return productService.getAllProducts();
    }

    @GetMapping("/available")
    public List<ProductDTO> getAvailableProducts() {
        List<Product> products = productService.getAvailableProducts();
        return products.stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getCategory()
                ))
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}