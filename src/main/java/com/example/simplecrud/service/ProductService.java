package com.example.simplecrud.service;

import com.example.simplecrud.entity.Product;
import com.example.simplecrud.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private  List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>() {{
            add(new Product("Iphone 13", 80000));
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
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new ProductNotFoundException("Product with name " + name + " wasn't found");
        }

        productList.get(index).setName(newProduct.getName()).setPrice(newProduct.getPrice());
    }

    public void deleteProduct(String name) {
        productList = productList.stream().filter(p -> !p.getName().equals(name)).collect(Collectors.toList());
    }
}
