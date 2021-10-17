package com.example.simplecrud.controller;

import com.example.simplecrud.entity.Product;
import com.example.simplecrud.exception.ProductNotFoundException;
import com.example.simplecrud.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @PutMapping("/edit/{name}")
    public ResponseEntity<String> updateProduct(@PathVariable(value = "name") String name, @RequestBody Product product) {
        try {
            service.updateProduct(name, product);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body("Product with this name doesn't exist");
        }
        return ResponseEntity.ok().body("Product was updated");
    }


    @DeleteMapping("/delete/{name}")
    public void deleteProduct(@PathVariable(value = "name") String name) {
        service.deleteProduct(name);
    }
}
