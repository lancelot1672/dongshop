package com.dore.shop.member.service;

import com.dore.shop.member.dto.MemberInfoRes;
import com.dore.shop.member.dto.MemberJoinDto;

public interface MemberService {
    void join(MemberJoinDto memberJoinDto);
    MemberInfoRes getMemberInfo(String memberId);
}
