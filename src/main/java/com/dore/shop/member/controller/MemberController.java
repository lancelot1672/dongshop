package com.dore.shop.member.controller;

import com.dore.shop.member.dto.MemberJoinDto;
import com.dore.shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class MemberController {
    private final MemberService memberService;

    @GetMapping(value = "/init")
    public String init(){
        return "Init Success";
    }

    @PostMapping(value = "/join")
    public String join(@RequestBody MemberJoinDto memberJoinDto){
        log.info(memberJoinDto);

        // 회원 가입
        memberService.join(memberJoinDto);

        return "Join Success";
    }
}
