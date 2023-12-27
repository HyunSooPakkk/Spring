package com.java.www.controller;

import java.util.List;
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
		//page 가지고 와야 함.
		//service 연결 - list
		List<BoardDto> list = bService.selectAll();
		//model 전송
		model.addAttribute("list",list);
		return "customer/notice";
	}
	
	@GetMapping("notice_view") //게시글 1개 가져오기
	public String notice_view(@RequestParam(defaultValue = "1") int bno,Model model) {
		//Service 연결
		Map<String, Object> map = bService.selectOne(bno);
		//Model 전송
		model.addAttribute("map", map);
		
		return "customer/notice_view";
	}
	
	
	@PostMapping("BCommentInsert") //댓글 1개 저장
	@ResponseBody //Ajax 데이터 전송
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		System.out.println("BController BCommentInsert bno: "+cdto.getBno());
		
		//Service 연결
		BCommentDto bCommentDto = bService.bCommentInsert(cdto);
		
		return bCommentDto;
	}
	
	
	
	
	
	
}
