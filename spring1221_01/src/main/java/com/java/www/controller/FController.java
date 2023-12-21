package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;
import com.java.www.service.EService;

@Controller
public class FController {
	
	@Autowired
	EService eService;

	@GetMapping("/") 
	public String index() {
		
		return "index";
	}
	
	@GetMapping("list") 
	public String list(Model model) {
		ArrayList<EmpDto> list = eService.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping("list2") 
	public String list2(Model model) {
		ArrayList<EmpDeptDto> list = eService.list2();
		model.addAttribute("list", list);
		
		return "list2";
	}
	
	
	
}//FController
