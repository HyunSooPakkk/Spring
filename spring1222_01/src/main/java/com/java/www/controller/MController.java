package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("login")           //로그인 페이지
	public String login() {
		return "member/login";
	}
	
	@PostMapping("doLogin")          //로그인 확인
	public String doLogin(MemberDto mdto, Model model, HttpServletRequest request) {
		int result = 0;
		System.out.println("MController id: "+mdto.getId());
		System.out.println("MController pw: "+mdto.getPw());
		MemberDto memberDto = mService.loginSelect(mdto); //id,pw
		
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			System.out.println("MController id 있음: "+memberDto.getId());
			result=1;
		}else {
			System.out.println("MController memberDto: null");
		}
		
		
		model.addAttribute("result", result);
		return "member/doLogin";
	}//doLogin
	
	
	@GetMapping("logout")           //로그아웃
	public String logout() {
		return "member/logout";
	}
	
	
	@PostMapping("join01")
	public String join01() {
		return "member/join01";
	}
	
	
	@PostMapping("join02")
	public String join02() {
		return "member/join02";
	}
	
	@PostMapping("idCheck")
	@ResponseBody //ajax
	public String idCheck(String id) {
		System.out.println("MController idCheck id: "+id);
		String result = "사용 가능";
		result = mService.idCheck(id);
		
		
		return "member/idCheck";
	}
	
	
	@PostMapping("join03")
	public String join03() {
		return "member/join03";
	}

}//MController
