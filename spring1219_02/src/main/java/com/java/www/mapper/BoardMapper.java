package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//전체 게시글 가져오기
	ArrayList<BoardDto> selectAll();
	//게시글 1개 가져오기
	BoardDto selectOne(int bno);
	//이전글 가져오기
	BoardDto selectOnePrev(int bno);
	//다음글 가져오기
	BoardDto selectOneNext(int bno);
	

}//BoardMapper
