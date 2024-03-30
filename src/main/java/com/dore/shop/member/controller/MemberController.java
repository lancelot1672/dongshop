package com.dore.shop.member.controller;

import com.dore.shop.member.dto.MemberInfoRes;
import com.dore.shop.member.dto.MemberJoinDto;
import com.dore.shop.member.dto.MemberLoginDto;

import com.dore.shop.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/login")
    public String login(HttpSession httpSession, @RequestBody MemberLoginDto memberLoginDto) {
        log.info(memberLoginDto);

        String login = memberService.login(memberLoginDto);

        if (login.equals("success")) {
            httpSession.setAttribute("loginId", memberLoginDto.getId());
        }

        // success or fail
        return login;
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> getMemberInfo(@RequestBody String memberId){
        log.info("Member ID : {}", memberId);
        //Session

        //
        MemberInfoRes memberInfo = memberService.getMemberInfo(memberId);
        return new ResponseEntity<MemberInfoRes>(memberInfo, HttpStatus.OK);
    }
}
