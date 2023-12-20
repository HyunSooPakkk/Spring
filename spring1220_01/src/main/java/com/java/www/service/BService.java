package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {

	//게시글 전체 가져오기 - 리스트
	ArrayList<BoardDto> selectAll();

	//게시글 하나 가져오기 - 뷰
	Map<String, Object> selectOne(int bno);
	
	

}
