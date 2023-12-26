package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//공지사항 전체 가져오기
	ArrayList<BoardDto> selectAll();
	//게시글 한 개 가져오기
	BoardDto selectOne(int bno);
	//댓글 가져오기
	ArrayList<BCommentDto> BCommentSelectAll(int bno);
	//DB에 저장된 댓글 한 개 가져오기
	void BCommentInsert(BCommentDto cdto);
	//저장된 댓글 1개 가져오기
	BCommentDto BCommentSelectOne(int cno);

}//BoardMapper
