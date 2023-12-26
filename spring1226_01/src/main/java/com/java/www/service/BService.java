package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

public interface BService {
	
	//공지사항 리스트 전체 가져오기
	ArrayList<BoardDto> selectAll();
	//게시글 한 개 가져오기
	Map<String, Object> selectOne(int bno);
	//DB에 저장된 댓글 한 개 가져오기
	BCommentDto BCommentInsert(BCommentDto cdto);

}//BService
