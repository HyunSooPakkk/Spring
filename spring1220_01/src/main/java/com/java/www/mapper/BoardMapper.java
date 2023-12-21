package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	
	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll();

	//게시글 한 개 가져오기
	BoardDto selectOne(int bno);
	//이전글 가져오기
	BoardDto selectOnePrev(int bno);
	//다음글 가져오기
	BoardDto selectOneNext(int bno);
	//조회수 1 증가
	void bHitUp(int bno);
	
	//게시글 저장
	int bInsert(BoardDto bdto);
	
	
	
	

}
