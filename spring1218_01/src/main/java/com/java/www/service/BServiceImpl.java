package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public ArrayList<BoardDto> bList() {
		ArrayList<BoardDto> list = boardMapper.bList();
		return list;
	}

	@Override
	public BoardDto SelectOne(int bno) {
		BoardDto boardDto = boardMapper.SelectOne(bno);
		return null;
	}

	@Override
	public void bInsert(BoardDto bdto) {
		boardMapper.bInsert(bdto);
		
	}

	
	
}
