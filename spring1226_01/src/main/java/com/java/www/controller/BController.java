package com.java.www.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class BController {

	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@GetMapping("notice")
	public String notice(Model model) {
		
		//page 가져와야 함.
		//Service 연결 ArrayList
		ArrayList<BoardDto> list = bService.selectAll();
		
		//Model 전송
		model.addAttribute("list", list);
		
		return "customer/notice";
	}
	
	
	
	@GetMapping("notice_view") //게시글 한 개 가져오기
	public String notice_view(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("BController notice_view bno: "+bno);
		
		//Service 연결 - dto
		Map<String, Object> map = bService.selectOne(bno);
		
		//Model 전송
		model.addAttribute("map", map);
		
		return "customer/notice_view";
		
	}
	
	
	//Ajax 댓글 입력
	@PostMapping("BCommentInsert")
	@ResponseBody //Ajax일 때 꼭 붙여줘야 함
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		System.out.println("BController BCommentInsert cpw: "+cdto.getCpw());
		System.out.println("BController BCommentInsert ccontent: "+cdto.getCcontent());
		System.out.println("BController BCommentInsert bno: "+cdto.getBno());
		
		//id 추가
		cdto.setId((String)session.getAttribute("session_id"));
		
		//DB에 저장된 댓글 한 개 가져오기 ▶ cno, cdate 포함
		BCommentDto bCommentDto = bService.BCommentInsert(cdto); 
		
		return bCommentDto;
	}
	
}//BController
