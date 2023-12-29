package com.java.www.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.IncomeDto;
import com.java.www.service.FService;

@Controller
public class FController {
	
	@Autowired FService fService;

	@GetMapping("/")
	public String main() {
		return "layout/main";
	}
	
	@GetMapping("layout/chart")
	public String chart() {
		return "layout/chart";
	}
	
	@PostMapping("/layout/incomeSelect")
	@ResponseBody
	public List<IncomeDto> incomeSelect(String cyear) {
		System.out.println("FController incomeSelect cyear: "+cyear);
		//Service 연결 >> 매출액 가져오기 (dto 하나 받아옴)
		List<IncomeDto> list = fService.incomeSelect(cyear);
		return list;
	}
	
	
	
	
	@GetMapping("layout/PublicData")
	public String PublicData() {
		return "layout/PublicData";
	}
	
	
	
	@GetMapping("layout/SearchData")
	@ResponseBody //데이터로 전송
	public String SearchData(String txt) throws Exception {
		System.out.println("SearchData txt: "+txt);
		String page = 1+"";
		String ServiceKey = "vUNH6KvsEqMp8muJeHO79CUd6OPL69sOgnyqLyRytXAjfNZyxQBeELZfErW7ebQOo8XIFfTdqsi%2F8TozRxd%2Few%3D%3D";
		String result= "";
		
		if(txt == null || txt.equals("")) {
			//사진목록 메소드 호출 >> 검색 단어가 없을 때
			result = galleryList(ServiceKey, page);
		}else{
			//사진목록 메소드 호출 >> 검색 단어가 있을 때
			result = gallerySearchList(txt, ServiceKey, page);
		}
		
		return result;
		
		
	}
	
	//사진 조회 메소드
	public String gallerySearchList(String txt, String ServiceKey, String page) throws Exception{
	
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" +ServiceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*OS 구분*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*정렬*/
        urlBuilder.append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(txt, "UTF-8")); /*검색어*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*데이터 타입*/
        //URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=vUNH6KvsEqMp8muJeHO79CUd6OPL69sOgnyqLyRytXAjfNZyxQBeELZfErW7ebQOo8XIFfTdqsi%2F8TozRxd%2Few%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
        URL url =new URL(urlBuilder.toString());
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
        StringBuilder sb = new StringBuilder(); //String을 계속 더하면 String 변수를 계속 새롭게 만듬.
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line); //JSON에 있는 데이터를 SB에 한 줄씩 저장.
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		
		return sb.toString();
		
	}//gallerySearchList

	
	
	//사진 목록 메소드
	public String galleryList(String ServiceKey, String page) throws Exception{
		
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" +ServiceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*OS 구분*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*정렬*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*데이터 타입*/
        //URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=vUNH6KvsEqMp8muJeHO79CUd6OPL69sOgnyqLyRytXAjfNZyxQBeELZfErW7ebQOo8XIFfTdqsi%2F8TozRxd%2Few%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
        URL url =new URL(urlBuilder.toString());
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
        StringBuilder sb = new StringBuilder(); //String을 계속 더하면 String 변수를 계속 새롭게 만듬.
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line); //JSON에 있는 데이터를 SB에 한 줄씩 저장.
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		
		return sb.toString();
	}//galleryList
	
	
	//영화정보 
	@GetMapping("layout/ScreenData")
	public String ScreenData() {
		
		return "layout/ScreenData";
	}
	
	
	
	//영화정보 검색
	@GetMapping("layout/SearchScreen")
	@ResponseBody //데이터로 전송
	public String SearchScreen() throws Exception {
		
		String ServiceKey = "1676281afb72e0060f81e70de0b82eac";
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "=" +ServiceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*목록 건수*/
        
        //URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=vUNH6KvsEqMp8muJeHO79CUd6OPL69sOgnyqLyRytXAjfNZyxQBeELZfErW7ebQOo8XIFfTdqsi%2F8TozRxd%2Few%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
        URL url =new URL(urlBuilder.toString());
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
        StringBuilder sb = new StringBuilder(); //String을 계속 더하면 String 변수를 계속 새롭게 만듬.
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line); //JSON에 있는 데이터를 SB에 한 줄씩 저장.
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		
		return sb.toString();
		
	}
	
	

}//FController


