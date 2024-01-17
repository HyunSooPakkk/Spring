package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {

	@GetMapping("/")
	public String index() {
		return "index";
	}// index()
	
	@GetMapping("aboutCB")
	public String aboutCB() {
		return "aboutCB";
	}// aboutCB()
	
	@GetMapping("developers")
	public String developers() {
		return "developers";
	}// developers()
	
	
	@GetMapping("adminPage")
	public String adminPage() {
		return "adminPage";
	}// adminPage()
	
	
	@GetMapping("chartjs")
	public String chartjs() {
		return "chartjs";
	}// chartjs()
	
	
	

}// FController
