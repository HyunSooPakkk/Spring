package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.www.dto.CppRDto;
import com.java.www.dto.CpsRDto;
import com.java.www.dto.FBoardDto;
import com.java.www.dto.KakaoDto;
import com.java.www.dto.LogoutDto;
import com.java.www.dto.TBoardDto;
import com.java.www.dto.TokenDto;
import com.java.www.dto.User_campDto;
//import com.java.www.service.EmailService;
import com.java.www.service.MyBoardService;
import com.java.www.service.MyInfoUpdateService;
import com.java.www.service.User_campService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("my")
public class MyController {
	
	@Autowired User_campService userCampService;
	
	@Autowired HttpSession session;
	
	//EmailService emailService;
	@Autowired MyBoardService myboardService;
	@Autowired MyInfoUpdateService myInfoUpdateService;

	
	@GetMapping("/")
	public String index() {
		return "index";
	}// index()
	
	@GetMapping("login")
	public String login() {
		return "/my/login";
	}// login()
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "/my/logout";
	}// logout()
	
	@RequestMapping("doLogin")
	public String doLogin(User_campDto ucdto, Model model, HttpServletRequest request) {
		int result = 0;
		System.out.println("FC id : "+ucdto.getId());
		System.out.println("FC pw : "+ucdto.getPw());
		
		User_campDto usercampDto = userCampService.loginSelect(ucdto);
		if(usercampDto != null) {
			session.setAttribute("session_id", usercampDto.getId());
			session.setAttribute("session_name", usercampDto.getName());
			
			result = 1;
		}else {
			System.out.println("FC userDto : null");
		}
		
		model.addAttribute("result", result);
		return "/my/doLogin";
	}// doLogin()
	

	
	//////////////////////////////////////////로그인(id, pw 찾기)
	//id 찾기
	@GetMapping("idpw_search") //idsearch페이지열기
	public String idpw_search() {
		return "/my/idpw_search";
	}// idpw_search()
	
	
	@PostMapping("id_s") //ajax 아이디찾기- name,email
	@ResponseBody
	public String id_s(String name, String email) {
		System.out.println("FC idsearch name : "+name);
		System.out.println("FC idsearch email : "+email);
		String result = userCampService.idsearch(name,email);
					
		return result;
	}// id_s()

	
	//id 찾기완료
	@GetMapping("idsearch")
	public String idsearch() {
		return "/my/idsearch";
	}// login()
	
	
	//비밀번호 찾기
	@PostMapping("pw_s")
	@ResponseBody
	public String pw_s(String id, String email) {
		System.out.println("MyController id_s : "+id);
		//service연결 비밀번호 찾기-아이디,이메일검색
		String result = userCampService.pw_s(id,email);
		return result;
	}
	
//	@PostMapping("email")
//	@ResponseBody
//	public String email(String email) {
//		System.out.println("MController email : "+email);
//		
//		//service연결 - 이메일주소 보냄.
//		String result = emailService.mailSend(email);
//		return result;
// }
	
	@PostMapping("pwChk") //인증코드 확인
	@ResponseBody
	public String pwChk(String pwcode) {
		System.out.println("MController pwcode : "+pwcode);
		String pw = (String) session.getAttribute("email_pwcode");
		String result ="fail";
		if(pw.equals(pwcode)) result="success";
		
		return result;
	}
	
	
	//pw 찾기완료
	@GetMapping("pwsearch")
	public String pwsearch() {
		return "/my/pwsearch";
	}// login()
	
	
	//회원가입 페이지
	@GetMapping("signUp")
	public String signUp() {
		return "/my/signUp";
	}// signUp()
	
	
	//회원가입 저장
	@PostMapping("signUp")
	@ResponseBody
	public String signUp(User_campDto ucdto) {
		
		String result = userCampService.signUp(ucdto);
		return result;
	}// signUp()
	
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String id) {
		String result = userCampService.idCheck(id);
		return result;
	}
	
	//회원가입 완료
	@GetMapping("signUp02")
	public String signUp02() {
		return "/my/signUp02";
	}// signUp02()
	
	
	/////////////////////////////////////////////마이페이지
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
	ArrayList<FBoardDto> list = myboardService.fbList(); 
	//Model에 자유게시판 데이터 담기
	model.addAttribute("list", list);
				
	//캠핑장리뷰 리스트(게시물 3개) 가져오기
	ArrayList<CpsRDto> list2 = myboardService.cpsRList(); 
	//Model에 자유게시판 데이터 담기
	model.addAttribute("list2", list2);
				
	//캠핑꿀팁 리스트(게시물 3개) 가져오기
	ArrayList<TBoardDto> list3 = myboardService.tList(); 
	//Model에 자유게시판 데이터 담기
	model.addAttribute("list3", list3);
				
	//캠핑용품리뷰 리스트(게시물 3개) 가져오기
	ArrayList<CppRDto> list4 = myboardService.cppRList(); 
	//Model에 자유게시판 데이터 담기
	model.addAttribute("list4", list4);
				
	return "/my/myList";
	}// myList()
			
		
	
	//마이 페이지-파티원
	@GetMapping("myParty")
	public String myParty() {
	return "/my/myParty";
	}// myParty()
	
	
	//마이 페이지-렌탈
	@GetMapping("myRental")
	public String myRental() {
	return "/my/myRental";
	}// myRental()
	
	
	//마이페이지 - 내정보수정
	@PostMapping("myInfoUpdate")
	public String myInfoUpdate(@RequestParam String mail_id,@RequestParam String mail_tail, 
			User_campDto userCampdto) {
		System.out.println("mail_id : "+mail_id);
		userCampdto.setEmail(mail_id+"@"+mail_tail);
		System.out.println("User_campDto 닉네임 : "+userCampdto.getNickname());
		System.out.println("User_campDto email : "+userCampdto.getEmail());
		
		return "/my/myInfo";
	}// myRental()
	
	
	////////////////////////////////마이 페이지 - 내 정보 수정//////////////////////////////////
	@PostMapping("myInfo") //내 정보 가져오기
	public String myInfo(User_campDto userCampdto, Model model) {
	
	System.out.println("MyController id : "+userCampdto.getId());
		
	//Service연결(DB)
	User_campDto user_Campdto = myInfoUpdateService.selectOne(userCampdto.getId());
	System.out.println("확인 : " +user_Campdto.getId());
	System.out.println("확인 : " +user_Campdto.getName());
	System.out.println("확인 : " +user_Campdto.getPw());
	System.out.println("확인 : " +user_Campdto.getNickname());
	
	//Model 저장 후 전송
	model.addAttribute("udto", user_Campdto);
	
	return "/my/myInfo";
	}// myInfo()
	
	
	//내 정보 수정하기
	//비밀번호 수정 //Ajax
	@RequestMapping("PwUpdate")
	@ResponseBody 
	public String PwUpdate(User_campDto userCampdto) {
		
		System.out.println("MyController pw update:"+userCampdto.getPw());
		
		//service연결
		myInfoUpdateService.PwUpdate(userCampdto);
			
		return "변경완료";
	}//비밀번호 수정

	//닉네임 수정
	@RequestMapping("nickNameUpdate")
	@ResponseBody
	public String nickNameUpdate(User_campDto userCampdto) {
		System.out.println("MyController nickname update:"+userCampdto.getNickname());
		
		//service연결
		myInfoUpdateService.nickNameUpdate(userCampdto);
					
		return "nickname";
	}
	
	//이메일 수정
	@RequestMapping("emailUpdate")
	@ResponseBody
	public String emailUpdate(User_campDto userCampdto) {
		System.out.println("MyController email update:"+userCampdto.getEmail());
		
		//service연결
		myInfoUpdateService.emailUpdate(userCampdto);
					
		return "email";
	}
	
	
	//주소 수정
	
	//휴대전화 수정
	
	//지역 수정
	
	
			
	/////////////////////////////////////////////마이페이지
	
	
}
