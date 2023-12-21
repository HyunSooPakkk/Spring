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
	
	//게시글 전체 가져오기 + 검색
	@Override
	public Map<String, Object> selectSearchCount(int page, String category, String searchWord) {
		//하단 넘버링
		if(page<=0) page=1;
		int countPerPage =10; //한 페이지당 게시글 수 
		int bottomPerNum = 10; //하단 넘버링 개수
		int countAll = boardMapper.selectSearchCount(category, searchWord); //게시글 검색 총 개수
		System.out.println("BServiceImpl countAll: "+countAll);
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		System.out.println("BServiceImpl maxPage: "+maxPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1; //1,11,21,31,41...
		int endRow = startRow+countPerPage-1; //10,20,30,40
		
		//starPage:1-endPage:10일 때 maxPage가 5이면
		//endPage에 maxPage를 넣어서 1-10 나오는 것이 아니라 1-5까지만 나타나도록 함
		if(endPage>maxPage) endPage=maxPage;
		ArrayList<BoardDto> list = boardMapper.selectSearch(startRow,endRow,category,searchWord);
		System.out.println("BServiceImpl : ");
		
		//게시글전체 가져오기
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	} 
	
	@Override
	public Map<String, Object> selectAll(int page, String category, String searchWord) {
		//하단 넘버링
		int countPerPage =10; //한 페이지당 게시글 수 
		int bottomPerNum = 10; //하단 넘버링 개수
		int countAll = boardMapper.selectCountAll(category,searchWord);
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1; //1,11,21,31,41...
		int endRow = startRow+countPerPage-1; //10,20,30,40
		
		//starPage:1-endPage:10일 때 maxPage가 5이면
		//endPage에 maxPage를 넣어서 1-10 나오는 것이 아니라 1-5까지만 나타나도록 함
		if(endPage>maxPage) endPage=maxPage;
		
		ArrayList<BoardDto> list = boardMapper.selectAll(startRow,endRow,category,searchWord);
		
		//게시글전체 가져오기
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
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
