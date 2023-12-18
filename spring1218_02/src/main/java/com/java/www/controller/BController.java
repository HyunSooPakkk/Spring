package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
public class BController {
	
	@Autowired
	BService bService;
	
	@RequestMapping("bList")
	public String bList(Model model) {
		
		//게시글 전체 가져오기
		ArrayList<BoardDto> list = bService.bList();
		
		model.addAttribute("list", list); 
		
		return "bList";
		
	}//bList
		
		//게시글 1개 가져오기
		@RequestMapping("bView")
		public String bView(@RequestParam(defaultValue = "1") int bno, Model model) {
			
			System.out.println("BController bno: "+bno);
			
			//Service 연결 - 게시글 1개 가져오기
			BoardDto boardDto = bService.SelectOne(bno);
			
			model.addAttribute("bdto", boardDto);
			return "board/bView";
		}//bView
		
	
	
}//BController
