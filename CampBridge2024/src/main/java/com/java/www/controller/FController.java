package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {

	@GetMapping("/")
	public String index() {
		return "index";
	}// index()
	
	
	//사이트 소개 페이지
	@GetMapping("aboutCB")
	public String aboutCB() {
		return "aboutCB";
	}// aboutCB()
	
	
	//개발자 소개 페이지
	@GetMapping("developers")
	public String developers() {
		return "developers";
	}// developers()
	
	
	//관리자 페이지 메인
	@GetMapping("adminPage")
	public String adminPage() {
		return "adminPage";
	}// adminPage()
	
	
	//관리자-회원 관리 페이지(List)
	@GetMapping("pages_userlist")
	public String pages_userlist() {
		return "pages_userlist";
	}// pages_userlist()
	
	//관리자-회원 관리 페이지(View)
	@GetMapping("pages_userview")
	public String pages_userview() {
		return "pages_userview";
	}// pages_userview()
	
	
	//관리자-공지사항 및 이벤트 페이지
	@GetMapping("pages_faq")
	public String pages_faq() {
		return "pages_faq";
	}// pages_faq()
	
	
	//관리자-입점 캠핑장 페이지
	@GetMapping("pages_campsite")
	public String pages_campsite() {
		return "pages_campsite";
	}// pages_campsite()
	
	
	//관리자-게시글 및 리뷰 페이지
	@GetMapping("pages_review")
	public String pages_review() {
		return "pages_review";
	}// pages_review()

	
	//관리자-에러404 페이지
	@GetMapping("pages_error404")
	public String pages_error404() {
		return "pages_error404";
	}// pages_error404()
	
	
	

}// FController
