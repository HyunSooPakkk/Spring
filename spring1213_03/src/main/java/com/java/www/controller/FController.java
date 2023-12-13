package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //JSP 페이지를 오픈해달라는 어노테이션
public class FController {
	
	@GetMapping("/") //[/]:root
	public String index() {
		return "index";
	}
	
}
