package com.example.shop.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MemberUpdateRequest {

    // 회원 아이디
    private String loginId;

    // 비밀번호
    private String password;

    // 전화번호
    private String phoneNumber;

    // 주소
    private String address;

    public MemberUpdateRequest(String address, String phoneNumber, String password, String loginId) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.loginId = loginId;
    }
}
