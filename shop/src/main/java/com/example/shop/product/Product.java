package com.example.shop.product;

import com.example.shop.order.Order;
import com.example.shop.orderproduct.OrderProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @OneToMany
    private List<OrderProduct> orderProducts;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "product_quantity")
    private int productQuantity;


    /**
     * 상품 생성자
     */
    public Product(String productName, int productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    /**
     * 상품 정보 수정 메서드
     */
    public void updateInfo(String productName, int productPrice) {
        if (this.productName != null) {
            this.productName = productName;
        }
        if (this.productPrice != 0) {
            this.productPrice = productPrice;
        }
    }
}
