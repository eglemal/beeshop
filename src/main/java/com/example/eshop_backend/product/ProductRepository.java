package com.example.eshop_backend.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    Product findByProductName(String productName);

    List<Product> getAll();


}
