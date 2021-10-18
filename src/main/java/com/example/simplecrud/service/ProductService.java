package com.example.simplecrud.service;

import com.example.simplecrud.entity.Product;
import com.example.simplecrud.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>() {{
            add(new Product("Iphone", 80000));
            add(new Product("Samsung Galaxy S21", 120000));
            add(new Product("One Plus 9PRO", 55000));
        }};
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(String name, Product newProduct) throws ProductNotFoundException {
        var product = productList.stream().filter(p ->p.getName().equals(name)).findFirst().orElseThrow(ProductNotFoundException::new);

        product.setPrice(newProduct.getPrice()).setName(newProduct.getName());
    }


    public void deleteProduct(String name) {
        productList = productList.stream().filter(p -> !p.getName().equals(name)).collect(Collectors.toList());
    }
}
