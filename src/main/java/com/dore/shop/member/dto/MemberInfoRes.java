package com.dore.shop.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfoRes {
    private String name;
    private String email;

}
