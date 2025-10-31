package com.example.shop.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public class OrderRepository {

    @PersistenceContext
    public EntityManager em;

    // 주문 정보 저장
    public Order save(Order order) {
        em.persist(order);
        return order;
    }

    // 주문 목록 조회
    public List<Order> findAll() {
        return em.createQuery("select o from Order o", Order.class).getResultList();
    }

    // 주문 조회
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    // 주문 삭제
    public void deleteById(Long id) {
        em.remove(id);
    }
}
