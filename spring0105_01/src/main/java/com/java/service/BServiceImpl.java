package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.mapper.BoardMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class BServiceImpl implements BService {

	@Autowired BoardMapper boardMapper;
	@Autowired HttpSession session;
	
	
	//게시글 전체 가져오기
	@Override 
	public List<BoardDto> selectAll() {
		List<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	//글쓰기 저장
	@Override
	public void bWrite(BoardDto bdto) {
		boardMapper.bWrite(bdto);
	}//bWrite

	//게시글 1개 가져오기
	@Override
	public BoardDto selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

}//BServiceImpl
