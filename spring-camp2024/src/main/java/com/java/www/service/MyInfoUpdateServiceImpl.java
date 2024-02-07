package com.java.www.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.User_campDto;
import com.java.www.mapper.MyInfoUpdateMapper;

@Service
public class MyInfoUpdateServiceImpl implements MyInfoUpdateService {

	@Autowired
	MyInfoUpdateMapper myInfoUpdateMapper;

	@Override //내 정보 가져오기
	public User_campDto selectOne(String id) {
		System.out.println("MyInfoServiceImpl : "+id);
		User_campDto userCampdto = myInfoUpdateMapper.selectOne(id);
		
		System.out.println("User_campDto.email : " +userCampdto.getEmail());
		
		return userCampdto;
	}// selectOne(id)

	@Override //비밀번호 변경
	public String PwUpdate(User_campDto userCampdto) {

		//Mapper 연결
		String re="";
		int result = myInfoUpdateMapper.PwUpdate(userCampdto);
		
		return result+re;
	}//PwUpdate

	@Override //닉네임 변경
	public String nickNameUpdate(User_campDto userCampdto) {
		//Mapper 연결
		String result = myInfoUpdateMapper.nickNameUpdate(userCampdto);
		
		return result;
	}//NicknameUpdate

	@Override //이메일 변경
	public String emailUpdate(User_campDto userCampdto) {
		//Mapper 연결
		String result = myInfoUpdateMapper.emailUpdate(userCampdto);
				
		return result;
		
	}




}// MyInfoUpdateServiceImpl
