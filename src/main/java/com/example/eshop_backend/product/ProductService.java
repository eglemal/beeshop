package com.example.eshop_backend.product;

import com.example.eshop_backend.error.NotFoundException;
import com.example.eshop_backend.user.User;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private long totalPrice = 0;

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getByProductName(String productName) {
        Product inDB = productRepository.findByProductName(productName);
        if(inDB == null) {
            throw new NotFoundException(productName + " not found");
        }
        return inDB;
    }
}
