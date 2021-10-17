package com.example.simplecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
public class Product {
    private String name;
    private int price;


    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }
}
