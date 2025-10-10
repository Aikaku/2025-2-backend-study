package com.example.shop.product;

import com.example.shop.order.OrderService;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderService orderService;

    // 상품 정보 등록
    public Long createProduct(ProductCreateRequest request) {
        Product existProduct = productRepository.findByName(request.getName());

        if (existProduct != null) {
            throw new RuntimeException("이미 존재하는 상품입니다." + request.getName());
        }

        Product product = new Product(); // request의 필드 주입 필요

        return productRepository.save(product).getId();
    }

    // 상품 목록 조회
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 개별 상품 정보 상세 조회
    public Product getProduct(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("존재하지 않는 상품입니다.");
        }

        return product;
    }

    // 상품 정보 수정
    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("존재하지 않는 상품입니다.");
        }

        product.updateInfo(); // request의 필드 주입 필요
    }

    // 상품 삭제
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("존재하지 않는 상품입니다.");
        }

        productRepository.deleteById(id);
    }
}
