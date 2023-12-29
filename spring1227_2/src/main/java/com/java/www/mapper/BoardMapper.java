package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

		// 공지사항 전체 가져오기
		List<BoardDto> selectAll();

		// 게시글 1개 가져오기
		BoardDto selectOne(int bno);

		// 하단 댓글 모두 가져오기
		List<BCommentDto> bCommentSelectAll(int bno);

		// 댓글 1개 저장
		void bCommentInsert(BCommentDto cdto);

		// 댓글 1개 가져오기
		BCommentDto bCommentSelectOne(int cno);

	


}
