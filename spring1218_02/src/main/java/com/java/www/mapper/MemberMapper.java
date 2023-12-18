package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;

//로그인 확인
@Mapper
public interface MemberMapper {

	MemberDto loginSelect(MemberDto mdto);
	
}
