package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.CppRDto;
import com.java.www.dto.CpsRDto;
import com.java.www.dto.FBoardDto;
import com.java.www.dto.TBoardDto;
import com.java.www.service.MyBoardService;

@Controller
@RequestMapping("my")
public class MyController {
	
	@Autowired
	MyBoardService myBoardService;
	
	
	//로그인 페이지
	@GetMapping("login")
	public String login() {
		return "/my/login";
	}// login()
	
	//id 찾기
	@GetMapping("idpw_search")
	public String idpw_search() {
		return "/my/idpw_search";
	}// login()
	
	//id 찾기완료
	@GetMapping("idsearch")
	public String idsearch() {
		return "/my/idsearch";
	}// login()
	
	//pw 찾기완료
	@GetMapping("pwsearch")
	public String pwsearch() {
		return "/my/pwsearch";
	}// login()
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////로그인(id, pw 찾기)
	
	//회원가입 페이지
	@GetMapping("signUp")
	public String signUp() {
		return "/my/signUp";
	}// signUp()
	
	//회원가입 완료
	@GetMapping("signUp02")
	public String signUp02() {
		return "/my/signUp02";
	}// signUp02()
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////회원가입

	//마이페이지
	@GetMapping("myPage")
	public String myPage() {
		return "/my/myPage";
	}// myPage()
	
	
	//마이 페이지 - 나의 게시물
	@GetMapping("myList")
	public String myList(Model model) {
		System.out.println("MyController : "+1);
		
		//자유게시판 리스트(게시물 3개) 가져오기
		ArrayList<FBoardDto> list = myBoardService.fbList(); 
		//Model에 자유게시판 데이터 담기
		model.addAttribute("list", list);
		
		//캠핑장리뷰 리스트(게시물 3개) 가져오기
		ArrayList<CpsRDto> list2 = myBoardService.cpsRList(); 
		//Model에 자유게시판 데이터 담기
		model.addAttribute("list2", list2);
		
		//캠핑꿀팁 리스트(게시물 3개) 가져오기
		ArrayList<TBoardDto> list3 = myBoardService.tList(); 
		//Model에 자유게시판 데이터 담기
		model.addAttribute("list3", list3);
		
		//캠핑용품리뷰 리스트(게시물 3개) 가져오기
		ArrayList<CppRDto> list4 = myBoardService.cppRList(); 
		//Model에 자유게시판 데이터 담기
		model.addAttribute("list4", list4);
		
		
		return "/my/myList";
	}// myList()
	
	
	
	//마이 페이지-파티원
	@GetMapping("myParty")
	public String myParty() {
		return "/my/myParty";
	}// myParty()
	
	//마이 페이지-회원정보수정
	@GetMapping("myInfo")
	public String myInfo() {
		return "/my/myInfo";
	}// myInfo()
	
	//마이 페이지-렌탈
	@GetMapping("myRental")
	public String myRental() {
		return "/my/myRental";
	}// myRental()
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////마이페이지

}
