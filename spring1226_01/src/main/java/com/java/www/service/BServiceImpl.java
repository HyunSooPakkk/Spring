package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapper boardMapper;

	@Override //공지사항 전체 리스트 가져오기
	public ArrayList<BoardDto> selectAll() {
		
		ArrayList<BoardDto> list = boardMapper.selectAll();
		
		return list;
	}

	@Override //게시글 한 개 가져오기
	public Map<String, Object> selectOne(int bno) {
		System.out.println("BServiceImpl selectOne bno: "+bno);
		
		//게시글 1개와 댓글 전체 가져오기
		Map<String, Object> map = new HashMap<>();
		BoardDto bdto = boardMapper.selectOne(bno);
		ArrayList<BCommentDto> list = boardMapper.BCommentSelectAll(bno);
		
		map.put("bdto", bdto);
		map.put("list", list);
		return map;
	}

	@Override //DB에 저장된 댓글 한 개 가져오기
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		//댓글 1개 저장
		boardMapper.BCommentInsert(cdto);
		System.out.println("BServiceImpl BCommentInsert cno: "+cdto.getCno());
		//저장된 댓글 1개 가져오기
		BCommentDto bCommentDto = boardMapper.BCommentSelectOne(cdto.getCno());
		System.out.println("BServiceImpl bCommentDto ccontent: "+bCommentDto.getCcontent());
		
		return bCommentDto;
	}

}//BServiceImpl
