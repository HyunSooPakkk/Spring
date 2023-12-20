package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;
	
	//게시글 전체 가져오기
	@Override
	public ArrayList<BoardDto> selectAll() {
		
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	//게시글 하나 가져오기 + 이전글,다음글 가져오기
	@Override
	public Map<String, Object> selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		BoardDto prevdto = boardMapper.selectOnePrev(bno);
		BoardDto nextdto = boardMapper.selectOneNext(bno);
		
		//조회수 1 증가
		boardMapper.bHitUp(bno);
		
		Map<String, Object> map = new HashMap<>();
		map.put("bdto", bdto);
		map.put("prevdto", prevdto);
		map.put("nextdto", nextdto);
		
		return map;
	}

}
