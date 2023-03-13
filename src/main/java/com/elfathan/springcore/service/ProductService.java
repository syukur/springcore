package com.elfathan.springcore.service;

import com.elfathan.springcore.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository =productRepository;
    }

    public ProductService(ProductRepository productRepository, String name){

    }
}
