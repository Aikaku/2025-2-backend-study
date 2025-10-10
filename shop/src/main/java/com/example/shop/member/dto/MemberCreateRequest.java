package com.example.shop.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MemberCreateRequest{

    // 회원 아이디
    private String loginId;

    // 비밀번호
    private String password;

    // 전화번호
    private String phoneNumber;

    // 주소
    private String address;

    public MemberCreateRequest(String address, String password, String loginId, String phoneNumber) {
        this.address = address;
        this.password = password;
        this.loginId = loginId;
        this.phoneNumber = phoneNumber;
    }
}
