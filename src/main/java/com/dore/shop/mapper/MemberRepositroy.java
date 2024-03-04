package com.dore.shop.mapper;

import com.dore.shop.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepositroy {
    Member getUserById(String id);
    void save(Member member);
}
