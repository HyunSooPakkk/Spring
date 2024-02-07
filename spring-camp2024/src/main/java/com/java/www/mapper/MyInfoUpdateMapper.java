package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.User_campDto;

@Mapper
public interface MyInfoUpdateMapper {
	
	//내 정보 가져오기
	User_campDto selectOne(String id);

	//비밀번호 변경
	int PwUpdate(User_campDto userCampdto);
	//닉네임 변경
	String nickNameUpdate(User_campDto userCampdto);
	//이메일 변경
	String emailUpdate(User_campDto userCampdto);
	
	

}//MyInfoUpdateMapper
