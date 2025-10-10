package com.example.shop.member;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 등록
    // @Transactional
    public Long createMember(MemberCreateRequest request) {
        Member existMember = memberRepository.findByLoginId(request.getLoginId());

        if (existMember != null) {
            throw new RuntimeException("이미 존재하는 아이디입니다." + request.getLoginId());
        }
        else {
            Member member = new Member(
                    request.getLoginId(),
                    request.getPassword(),
                    request.getPhoneNumber(),
                    request.getAddress()
            );
            return memberRepository.save(member).getId();
        }
    }

    // 회원 목록 조회
    @Transactional (readOnly = true) // 정보의 수정 없이 읽기만 했을 경우
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 개별 회원 정보 상세 조회
    @Transactional (readOnly = true)
    public Member getMemberById(Long id) {
        Member member = memberRepository.findById(id);

        if(member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        return member;
    }

    // 회원 정보 수정
    // @Transactional
    public void updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        member.updateInfo(request.getPassword(), request.getPhoneNumber(), request.getAddress());
    }

    // 회원 삭제
    // @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        memberRepository.deleteById(id);
    }
}
