package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.CppRDto;
import com.java.www.dto.CpsRDto;
import com.java.www.dto.FBoardDto;
import com.java.www.dto.TBoardDto;
import com.java.www.mapper.MyBoardMapper;

@Service
public class MyBoardServiceImpl implements MyBoardService {

	@Autowired
	MyBoardMapper myboardMapper;
	
	@Override //나의 게시글 자유게시판 리스트(게시물 3개) 가져오기
	public ArrayList<FBoardDto> fbList() {
		System.out.println("MyBoardServiceImpl : "+1);
		ArrayList<FBoardDto> list = myboardMapper.fbList();
		return list;
	}//fbList

	@Override //나의 게시글 캠핑장리뷰 리스트(게시물 3개) 가져오기
	public ArrayList<CpsRDto> cpsRList() {
		ArrayList<CpsRDto> list2 = myboardMapper.cpsRList();
		return list2;
	}//cpsRList

	@Override //나의 게시글 캠핑꿀팁 리스트(게시물 3개) 가져오기
	public ArrayList<TBoardDto> tList() {
		ArrayList<TBoardDto> list3 = myboardMapper.TList();
		return list3;
	}

	@Override //나의 게시글 캠핑용품리뷰 리스트(게시물 3개) 가져오기
	public ArrayList<CppRDto> cppRList() {
		ArrayList<CppRDto> list4 = myboardMapper.cppRList();
		return list4;
	}

	
	
	
}//MyBoardServiceImpl
