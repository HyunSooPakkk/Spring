package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {

	//전체 게시글 가져오기
	ArrayList<BoardDto> selectAll();
	//게시글 1개 가져오기
	Map<String, Object> selectOne(int bno);

}//BService
