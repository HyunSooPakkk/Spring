package com.java.www.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
public class BController {
	
	@Autowired
	BService bService;

	@GetMapping("bList") //게시글전체 가져오기
	public String bList(Model model) {
		//db에서 가져오기
		ArrayList<BoardDto> list = bService.selectAll();
		//model 저장
		model.addAttribute("list", list);
		System.out.println("list개수 : "+list.size());
		
		return "board/bList";
	}//bList
	
	@GetMapping("bView") //게시글1개 가져오기
	public String bView(@RequestParam(defaultValue = "1") int bno,Model model) {
		System.out.println("BController bno : "+bno);
		//db에서 가져오기
		Map<String, Object> map = bService.selectOne(bno);
		//model저장
		model.addAttribute("map",map);
		
		return "board/bView";
	}//bView
	
}
