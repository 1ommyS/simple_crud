package com.example.simplecrud.exception;

/**
 * @author 1ommy
 * @version 17.10.2021
 */
public class ProductNotFoundException  extends Exception{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
