package com.example.shop.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    public EntityManager em;

    // 회원 등록
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    // 회원 목록 조회
    public List<Member> findAll() {
        // 전체를 찾는 것과 같이 복잡한 경우 JPQL을 사용해야 한다.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 회원 조회
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    // 로그인 아이디로 회원 조회
    public Member findByLoginId(String loginId) {
        List<Member> result = em.createQuery("select m from Member m where m.loginId", Member.class)
                .setParameter("loginId", loginId).getResultList();

        return result.isEmpty() ? null : result.get(0);
        // 결과 값이 null이면 null을 반환하고 결과 값이 있으면 하나일거기 때문에 첫번째 member를 반환하라.
    }

    // 회원 삭제
    public void deleteById(Long id) {
        em.remove(id);
    }
}
