package com.example.shop.order;

import com.example.shop.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // 주문 정보 생성
    public Long create(OrderCreateRequest request) {
        Order order = new Order(); // request의 필드 주입 필요
        return orderRepository.save(order).getId();
    }

    // 주문 목록 조회
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 개별 주문 정보 상세 조회
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("존재하지 않는 주문입니다.");
        }

        return order;
    }

    // 주문 취소
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("존재하지 않는 주문입니다.");
        }

        orderRepository.deleteById(id);
    }
}
