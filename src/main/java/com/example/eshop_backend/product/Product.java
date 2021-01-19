package com.example.eshop_backend.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Product {

    private long id;

    private String image;

    private String image2;

    private String image3;

    private String productName;

    private long price;

    private String description;



    public Product(long id, String image, String image2, String image3, String productName, long price, String description) {
        this.id = id;
        this.image = image;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image2 = image2;
        this.image3 = image3;
    }

    public long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getProductName() {
        return productName;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }
}
