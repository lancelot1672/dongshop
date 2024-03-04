package com.dore.shop.member.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private String id;
    private String password;
    private String name;
}
