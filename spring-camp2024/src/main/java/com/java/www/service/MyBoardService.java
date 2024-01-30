package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.CppRDto;
import com.java.www.dto.CpsRDto;
import com.java.www.dto.FBoardDto;
import com.java.www.dto.TBoardDto;

public interface MyBoardService {

	//자유게시판 리스트(게시물 3개) 가져오기
	ArrayList<FBoardDto> fbList();
	//캠핑장리뷰 리스트(게시물 3개) 가져오기
	ArrayList<CpsRDto> cpsRList();
	//캠핑꿀팁 리스트(게시물 3개) 가져오기
	ArrayList<TBoardDto> tList();
	//캠핑용품리뷰 리스트(게시물 3개) 가져오기
	ArrayList<CppRDto> cppRList();
	
	

}//MyBoardService
