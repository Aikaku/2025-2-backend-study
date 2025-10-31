package com.example.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @PersistenceContext
    public EntityManager em;

    // 상품 정보 저장
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    // 상품 목록 조회
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    // 상품 조회
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    // 이름으로 상품 조회
    public Product findByName(String name) {
        List<Product> result = em.createQuery("select p from Product p where name")
                .setParameter("name", name).getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // 상품 삭제
    public void deleteById(Long id) {
        em.remove(id);
    }
}
