package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public ArrayList<BoardDto> selectAll() {
		//게시글전체 가져오기
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public Map<String, Object> selectOne(int bno) {
		//게시글1개 가져오기, 이전글,다음글 가져오기 : 총3개
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

	//글쓰기 저장
	@Override
	public void bInsert(BoardDto bdto) {
		int result = boardMapper.bInsert(bdto);
		System.out.println("bServiceImpl result : "+result);
		
		
	}

	//게시글 삭제
	@Override
	public void bDelete(int bno) {
		int result = boardMapper.bDelete(bno);
		System.out.println("bServiceImpl bDelete result: "+result);
		
	}

	//게시글 수정 저장
	@Override
	public void doBUpdate(BoardDto bdto) {
		int result = boardMapper.doBUpdate(bdto);
		System.out.println("bServiceImpl doBUpdate result : "+result);
		
	}

	//답글달기 저장 - bgroup, bstep, bindent
	//1. 부모보다 큰 bstep은 1씩 증가시킴
	//2. 현재 답글의 bgroup=부모bgroup, bstep=부모bstep+1, ,bindent=부모bindent+1 
	@Override
	public void doBReply(BoardDto bdto) {
		boardMapper.bStepUp(bdto);
		int result = boardMapper.doBReply(bdto);
		System.out.println("bServiceImpl doBReply result : "+result);
		
	}

	

}
