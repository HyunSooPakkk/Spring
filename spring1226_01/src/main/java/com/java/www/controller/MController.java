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

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired MService mService;
	@Autowired HttpSession session;

	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	//로그인 확인 부분: Ajax
	@PostMapping("ajaxLogin")
	@ResponseBody //데이터 전송
	public String ajaxLogin(MemberDto mdto) {
		
		System.out.println("MController login id: "+mdto.getId());
		System.out.println("MController login pw: "+mdto.getPw());
		
		//Service 연결 = result 1(성공) or 0(실패)
		int result = mService.login(mdto);
		System.out.println("MController login result: "+result);
		
		return result+"";
	}
	
	
	//로그인 확인 부분: JSP
	@PostMapping("login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("MController login id: "+mdto.getId());
		System.out.println("MController login pw: "+mdto.getPw());
		
		//Service 연결 = result 1(성공) or 0(실패)
		int result = mService.login(mdto);
		
		System.out.println("MController login result: "+result);
		model.addAttribute("result", result);
		return "member/doLogin";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	
	
	
}
