package com.dore.shop.member.service;

import com.dore.shop.mapper.MemberRepositroy;
import com.dore.shop.member.dto.MemberJoinDto;
import com.dore.shop.member.dto.MemberLoginDto;
import com.dore.shop.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public String login(MemberLoginDto memberLoginDto) {
        Optional<Member> omember = memberRepositroy.getUserById(memberLoginDto.getId());

        // Password 암호화
        if (omember.isEmpty() || !omember.get().getPassword().equals(memberLoginDto.getPassword())){
            return "fail";
        }
        return "success";
    }
}
