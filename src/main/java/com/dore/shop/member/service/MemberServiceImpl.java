package com.dore.shop.member.service;

import com.dore.shop.mapper.MemberRepositroy;
import com.dore.shop.member.dto.MemberInfoRes;
import com.dore.shop.member.dto.MemberJoinDto;
import com.dore.shop.member.dto.MemberLoginDto;
import com.dore.shop.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepositroy memberRepositroy;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void join(MemberJoinDto memberJoinDto) {
        //Password Encoding
        String newPassword = bCryptPasswordEncoder.encode(memberJoinDto.getPassword());

        //dto to entity
        Member member = Member.builder()
                .id(memberJoinDto.getId())
                .password(newPassword)
                .name(memberJoinDto.getName()).build();

        //Mapper 호출을 통해 Save
        memberRepositroy.save(member);
    }
    @Override
    public String login(MemberLoginDto memberLoginDto) {
        Optional<Member> omember = memberRepositroy.getUserById(memberLoginDto.getId());

        //Null Check
        // 추후 통일 필요
        if (omember.isEmpty()) return "fail";

        //Password Check
        Member member = omember.get();
        if(!bCryptPasswordEncoder.matches(memberLoginDto.getPassword(),member.getPassword())) return "fail";

        return "success";
    }
    @Override
    public MemberInfoRes getMemberInfo(MemberLoginDto memberLoginDto) {
        Optional<Member> omember = memberRepositroy.getUserById(memberLoginDto.getId());
        //Null Check
        // 추후 통일 필요
        if (omember.isEmpty()) return null;
        Member member = omember.get();
        if(!bCryptPasswordEncoder.matches(memberLoginDto.getPassword(),member.getPassword())) return null;

        MemberInfoRes response = MemberInfoRes.builder()
                .name(omember.get().getName())
                .build();

        return response;
    }
}
