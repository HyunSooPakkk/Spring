package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("member")
public class MController {

	@Autowired
	MService mService;
	@Autowired
	HttpSession session;
	//HttpSession session = request.getSession();
	
	@GetMapping("mInsert")
	public String mInsert(Model model) {
		String id = "admin";
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		MemberDto mdto = new MemberDto("aaa", "1111", "홍길동", "010-1111-1111", "Male", "game,golf", mdate);
		model.addAttribute("mdto", mdto);
		
		System.out.println("MemberDto id: "+mdto.getId());
		
		return "member/mInsert";
	
	}//mInsert
	
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}//login
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}//logout
	
	@RequestMapping("doLogin")
	public String doLogin(MemberDto mdto, Model model, HttpServletRequest request) {
		int result=0;
		System.out.println("MController id: "+mdto.getId());
		System.out.println("MController pw: "+mdto.getPw());
		
		MemberDto memberDto = mService.loginSelect(mdto); //id,pw
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
			System.out.println("MController id 있음: "+memberDto.getId());
			result = 1;
		}else{
			System.out.println("MController memberDto: null");
		}
		
		model.addAttribute("result", result);
		return "member/doLogin";
	}//doLogin
	
	
}//MController
