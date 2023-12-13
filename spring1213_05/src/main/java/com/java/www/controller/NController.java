package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("notice")
public class NController {
	
	@GetMapping("noticeList") //notice 폴더 안에 있는 noticeList 파일
	public String noticeList() {
		return "notice/noticeList";
	}
	
	
	@GetMapping("noticeInsert")
	public String noticeInsert() {
		return "notice/noticeInsert";
	}
	
	@RequestMapping("noticeView")  //Request >> Get,Post 둘 다 가능
	public String noticeView() {
		return "notice/noticeView";
	}
	
	
}
