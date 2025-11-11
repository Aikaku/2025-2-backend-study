package com.example.shop.product.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private String name;

    private int price;

    private int quantity;

    public ProductCreateRequest(String productName, int productPrice, int productQuantity) {
        this.name = productName;
        this.price = productPrice;
        this.quantity = productQuantity;
    }
}
