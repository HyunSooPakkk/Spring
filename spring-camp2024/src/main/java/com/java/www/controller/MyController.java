package com.java.www.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.www.dto.CppRDto;
import com.java.www.dto.Cps_reviewDto;
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

	@Autowired
	User_campService userCampService;

	@Autowired
	HttpSession session;

	// EmailService emailService;
	@Autowired
	MyBoardService myboardService;
	@Autowired
	MyInfoUpdateService myInfoUpdateService;

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
		System.out.println("FC id : " + ucdto.getId());
		System.out.println("FC pw : " + ucdto.getPw());

		User_campDto usercampDto = userCampService.loginSelect(ucdto);
		if (usercampDto != null) {
			session.setAttribute("session_id", usercampDto.getId());
			session.setAttribute("session_name", usercampDto.getName());

			result = 1;
		} else {
			System.out.println("FC userDto : null");
		}

		model.addAttribute("result", result);
		return "/my/doLogin";
	}// doLogin()

	////////////////////////////////////////// 로그인(id, pw 찾기)
	// id 찾기
	@GetMapping("idpw_search") // idsearch페이지열기
	public String idpw_search() {
		return "/my/idpw_search";
	}// idpw_search()

	@PostMapping("id_s") // ajax 아이디찾기- name,email
	@ResponseBody
	public String id_s(String name, String email) {
		System.out.println("FC idsearch name : " + name);
		System.out.println("FC idsearch email : " + email);
		String result = userCampService.idsearch(name, email);

		return result;
	}// id_s()

	// id 찾기완료
	@GetMapping("idsearch")
	public String idsearch() {
		return "/my/idsearch";
	}// login()

	// 비밀번호 찾기
	@PostMapping("pw_s")
	@ResponseBody
	public String pw_s(String id, String email) {
		System.out.println("MyController id_s : " + id);
		// service연결 비밀번호 찾기-아이디,이메일검색
		String result = userCampService.pw_s(id, email);
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

	@PostMapping("pwChk") // 인증코드 확인
	@ResponseBody
	public String pwChk(String pwcode) {
		System.out.println("MController pwcode : " + pwcode);
		String pw = (String) session.getAttribute("email_pwcode");
		String result = "fail";
		if (pw.equals(pwcode))
			result = "success";

		return result;
	}

	// pw 찾기완료
	@GetMapping("pwsearch")
	public String pwsearch() {
		return "/my/pwsearch";
	}// login()

	// 회원가입 페이지
	@GetMapping("signUp")
	public String signUp() {
		return "/my/signUp";
	}// signUp()

	// 회원가입 저장
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

	// 회원가입 완료
	@GetMapping("signUp02")
	public String signUp02() {
		return "/my/signUp02";
	}// signUp02()

	///////////////////////////////////////////// 마이페이지
	// 마이페이지
	@GetMapping("myPage")
	public String myPage(Model model) {
		
		String id = (String) session.getAttribute("session_id");
		System.out.println("MyController id : " + id);

		// Service연결(DB)
		User_campDto user_Campdto = myInfoUpdateService.selectOne(id);

		// Model 저장 후 전송
		model.addAttribute("udto", user_Campdto);
		
		return "/my/myPage";
	}// myPage()

	// 마이 페이지 - 나의 게시물
	@GetMapping("myList")
	public String myList(Model model) {
		System.out.println("MyController : " + 1);
		String id = (String) session.getAttribute("session_id");
		System.out.println("마이컨트롤러 id: "+ id);
		
		// 자유게시판 리스트(게시물 3개) 가져오기
		ArrayList<FBoardDto> list = myboardService.fbList(id);
		// Model에 자유게시판 데이터 담기
		model.addAttribute("list", list);

		// 캠핑장리뷰 리스트(게시물 3개) 가져오기
		ArrayList<Cps_reviewDto> list2 = myboardService.cpsRList(id);
		// Model에 자유게시판 데이터 담기
		model.addAttribute("list2", list2);

		// 캠핑꿀팁 리스트(게시물 3개) 가져오기
		ArrayList<TBoardDto> list3 = myboardService.tList(id);
		// Model에 자유게시판 데이터 담기
		model.addAttribute("list3", list3);

		// 캠핑용품리뷰 리스트(게시물 3개) 가져오기
		ArrayList<CppRDto> list4 = myboardService.cppRList(id);
		// Model에 자유게시판 데이터 담기
		model.addAttribute("list4", list4);

		return "/my/myList";
	}// myList()

	// 마이 페이지-파티원
	@GetMapping("myParty")
	public String myParty() {
		return "/my/myParty";
	}// myParty()

	// 마이 페이지-렌탈
	@GetMapping("myRental")
	public String myRental() {
		return "/my/myRental";
	}// myRental()

	
	
	//////////////////////////////// 마이 페이지 - 내 정보 수정//////////////////////////////////
	@PostMapping("myInfo") // 내 정보 가져오기
	public String myInfo(User_campDto userCampdto, Model model) {

		System.out.println("MyController id : " + userCampdto.getId());

		// Service연결(DB)
		User_campDto user_Campdto = myInfoUpdateService.selectOne(userCampdto.getId());

		// Model 저장 후 전송
		model.addAttribute("udto", user_Campdto);

		return "/my/myInfo";
	}// myInfo()

	
	// 내 정보 수정(form)
	@PostMapping("doUpdate")
	public String myInfoUpdate(String nPw, User_campDto userCampdto, MultipartFile myfile, Model model) throws Exception {
		System.out.println("MyController 아이디 : " + userCampdto.getId());
		System.out.println("MyController 비밀번호 : " + userCampdto.getPw());
		System.out.println("MyController 닉네임 : " + userCampdto.getNickname());
		System.out.println("MyController 이메일 : " + userCampdto.getEmail());
		System.out.println("MyController 전화번호 : " + userCampdto.getPhone());
		System.out.println("MyController 주소 : " + userCampdto.getAddress());
		System.out.println("MyController 지역 : " + userCampdto.getLocal());
		System.out.println("MyController 파일 : " + userCampdto.getM_img());
		
		if (!myfile.isEmpty()) {
			String oriFName = myfile.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time + "_" + oriFName; // String upName = String.format("%s_%d", oriFName, time)
			String upload = "c:/upload/"; // 파일업로드 위치

			//파일업로드
			File f = new File(upload + upFName);
			myfile.transferTo(f);

			//userCampdto파일이름 저장
			userCampdto.setM_img(upFName);
		} else {
			userCampdto.setM_img("");
		} //if(myfile)

		//Service, Mapper
		String result = myInfoUpdateService.myInfoUpdate(userCampdto);
		System.out.println("컨트롤러 result : "+result);
		model.addAttribute("result", result);
		
		return "/my/doUpdate";
	}// myInfoUpdate()

	////////////////////////////////마이 페이지 - 내 정보 수정 끝//////////////////////////////////

}
