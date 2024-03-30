package com.dore.shop.mapper;

import com.dore.shop.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberRepositroy {
    Optional<Member> getUserById(String id);
    void save(Member member);

}
