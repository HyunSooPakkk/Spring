package com.java.www.service;

import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;

@Service
public interface MService {
	//로그인 확인
	MemberDto loginSelect(MemberDto mdto);
	
}
