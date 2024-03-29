package com.dore.shop.member.service;

import com.dore.shop.mapper.MemberRepositroy;
import com.dore.shop.member.dto.MemberInfoRes;
import com.dore.shop.member.dto.MemberJoinDto;
import com.dore.shop.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepositroy memberRepositroy;
    @Override
    public void join(MemberJoinDto memberJoinDto) {
        //dto to entity
        Member member = Member.builder()
                .id(memberJoinDto.getId())
                .password(memberJoinDto.getPassword())
                .name(memberJoinDto.getName()).build();

        //Mapper 호출을 통해 Save
        memberRepositroy.save(member);
    }

    @Override
    public MemberInfoRes getMemberInfo(String memberId) {
        Member member = memberRepositroy.getUserById(memberId);
        // Check Null
        // How to use Optional for Mybatis???
        if(member == null){

        }
        MemberInfoRes response = MemberInfoRes.builder()
                .name(member.getName())
                .build();

        return response;
    }
}
