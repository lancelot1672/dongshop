package com.dore.shop.member.service;

import com.dore.shop.member.dto.MemberInfoRes;
import com.dore.shop.member.dto.MemberJoinDto;
import com.dore.shop.member.dto.MemberLoginDto;

public interface MemberService {
    void join(MemberJoinDto memberJoinDto);
    String login(MemberLoginDto memberLoginDto);
    MemberInfoRes getMemberInfo(String memberId);
}
