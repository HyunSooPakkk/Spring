package com.java.www.service;

import java.util.List;
import java.util.Map;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

public interface BService {

	//공지사항 전체가져오기
	List<BoardDto> selectAll();

	//게시글 1개 가져오기
	Map<String, Object> selectOne(int bno);

	//댓글1개 저장 후 댓글 1개 가져오기
	BCommentDto bCommentInsert(BCommentDto cdto);

	//댓글 삭제
	String bCommentDelete(int cno);
	
	//댓글 수정 저장
	BCommentDto bCommentUpdate(BCommentDto cdto);

	

}
