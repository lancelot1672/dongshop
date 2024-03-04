package com.dore.shop.member.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberJoinDto {
    private String id;
    private String password;
    private String name;
}
