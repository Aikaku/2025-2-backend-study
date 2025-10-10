package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // 상품 정보 등록
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest requset) {
        Long productId = productService.createProduct(requset);
        return ResponseEntity.created(URI.create("/products/" + productId)).build();
    }

    // 상품 목록 조회
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // 개별 상품 정보 상세 조회
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(Long productId) {
        Product product = productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }

    // 상품 정보 수정
    @PatchMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(Long productId, ProductUpdateRequest request) {
        productService.updateProduct(productId, request);
        return ResponseEntity.ok().build();
    }

    // 상품 삭제
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
