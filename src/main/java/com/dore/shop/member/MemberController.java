package com.dore.shop.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MemberController {
    @GetMapping(value = "/init")
    public String init(){
        return "Init Success";
    }
}
