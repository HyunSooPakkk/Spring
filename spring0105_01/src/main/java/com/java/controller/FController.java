package com.java.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class FController {

	@Autowired
	BService bService;
	@Autowired
	HttpSession session;

	@GetMapping({ "/", "main", "index" })
	public String main() {
		return "main";
	}// main

	@GetMapping("bList")
	public String bList(Model model) {
		// 게시글 전체 가져오기
		List<BoardDto> list = bService.selectAll();
		model.addAttribute("list", list);

		return "bList";
	}// bList

	@GetMapping("bWrite")
	public String bWrite() {
		return "bWrite";
	}// bWrite

	@PostMapping("bWrite") // 글쓰기 저장
	public String bWrite(BoardDto bdto, @RequestPart MultipartFile file, Model model) throws Exception {
		System.out.println("FController bWrite btitle: " + bdto.getBtitle());
		if (!file.isEmpty()) {
			String oriFileName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = time + "_" + oriFileName; // 파일이름변경
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl + uploadFileName); // 파일등록
			file.transferTo(f); // 파일서버로 전송
			bdto.setBfile(uploadFileName); // dto bfile 이름 저장
		} else {
			bdto.setBfile(""); // dto bfile 이름 저장
		}

		System.out.println("FController bWrite bfile: " + bdto.getBfile());

		// Service 연결
		bService.bWrite(bdto);

		model.addAttribute("result", "success-bWrite");
		return "result";
	}// bWrite

	@GetMapping("bView") // 게시글 1개 가져오기
	public String bView(@RequestParam(defaultValue = "1") int bno, Model model) {
		BoardDto bdto = bService.selectOne(bno);
		model.addAttribute("bdto", bdto);

		return "bView";
	}// bView

	// Summernote에서 Ajax 이미지 전송
	@PostMapping("uploadImage")
	@ResponseBody
	public String uploadImage(@RequestPart MultipartFile file) throws Exception {
		String urlName = "";

		// 파일을 서버로 전송하는 부분
		if (!file.isEmpty()) {
			String oriFileName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = time + "_" + oriFileName; // 파일이름변경
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl + uploadFileName); // 파일등록
			file.transferTo(f); // 파일서버로 전송
			urlName = "/upload/" + uploadFileName;
			System.out.println("FController Ajax 링크 주소: " + urlName);

		}

		return urlName;
	}// uploadImage

	@GetMapping("map")
	public String map() {
		return "map";
	}// map

	// -------------------------------------
	// ------ 영화정보 : 일별 박스오피스 --------
	// -------------------------------------
	@GetMapping("screenData")
	public String screenData() {
		return "screenData";
	}

	/*
	 * @PostMapping("screenInfo")
	 * 
	 * @ResponseBody //데이터 전송 public String searchScreen(String txt) throws
	 * Exception { System.out.println("searchData txt : "+txt); String key
	 * ="1676281afb72e0060f81e70de0b82eac"; StringBuilder urlBuilder = new
	 * StringBuilder(
	 * "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
	 * ); URL urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "="+key);
	 * Service Key urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") +
	 * "=" + URLEncoder.encode("20240104", "UTF-8")); 응답메세지 형식 : REST방식의 URL호출 시
	 * json값 추가(디폴트 응답메세지 형식은XML) URL url = new URL(urlBuilder.toString()); //URL
	 * url = new URL(
	 * "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=918RE13GA7OY7ZEmUzApgbOeAcQoZ%2FaHsXWcqPAKQ9YNNPj83KOstRMRIUrCFIAcm9qj2R6b7NFZjp%2FYsYzJLg%3D%3D&numOfRows=10&pageNo=2&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json"
	 * ); HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	 * conn.setRequestMethod("GET"); conn.setRequestProperty("Content-type",
	 * "application/json"); System.out.println("Response code: " +
	 * conn.getResponseCode()); BufferedReader rd; if(conn.getResponseCode() >= 200
	 * && conn.getResponseCode() <= 300) { rd = new BufferedReader(new
	 * InputStreamReader(conn.getInputStream())); } else { rd = new
	 * BufferedReader(new InputStreamReader(conn.getErrorStream())); } StringBuilder
	 * sb = new StringBuilder(); //String 을 계속 더하면 String변수를 계속 새롭게 만듬. String line;
	 * while ((line = rd.readLine()) != null) { sb.append(line); //json데이터를 sb에 1줄씩
	 * 저장 } rd.close(); conn.disconnect(); System.out.println(sb.toString());
	 * 
	 * return sb.toString(); }//screenInfo
	 */
	
	@PostMapping("screenInfo")
	@ResponseBody
	public String screenInfo(String movie) throws Exception {
		System.out.println("Test Data: "+movie);
		//영화정보 API 가져오기
		String key = "1676281afb72e0060f81e70de0b82eac";
		//오늘 날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(System.currentTimeMillis());
		System.out.println("오늘 날짜: "+today);
		
	   StringBuilder urlBuilder = new StringBuilder("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"); /*URL*/
       urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "="+key); /*key*/
       urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("20240104", "UTF-8")); /*날짜*/
       URL url = new URL(urlBuilder.toString());
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("GET");
       conn.setRequestProperty("Content-type", "application/json");
       System.out.println("Response code: " + conn.getResponseCode());
       BufferedReader rd;
       if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
           rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
       } else {
           rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
       }
       StringBuilder sb = new StringBuilder();
       String line;
       while ((line = rd.readLine()) != null) {
           sb.append(line);
       }
       rd.close();
       conn.disconnect();
       System.out.println(sb.toString());
       return sb.toString();
	
		//
	}
	

}// FController
