package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId) {
        return repository.findById(productId).orElse(null);
    }
}
