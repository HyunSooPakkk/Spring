package com.java.www.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import com.java.www.dto.MemberDto;

//@RestController ▶ 컨트롤러 안의 모든 url 주소를 데이터로 전달해줘
@Controller
public class DataController {

	@ResponseBody
	@RequestMapping("boardBno/{bno}/{bhit}")
	public String boardBno(@PathVariable int bno, @PathVariable int bhit) {
		
		String txt = "boardBno 글 번호: "+bno;
		txt += ", 조회수 bhit: "+bhit;
		
		return txt; 
	}
	
	@RequestMapping("mInsert")
	public String mInsert() {
		return "mInsert"; //aaa.jsp
	}
	
	@ResponseBody
	@RequestMapping("idCheck")
	public Map<String, Object> idCheck(String id) {
		//DB검색: select * from member where id=?
		Map<String, Object> map = new HashMap<>();
		ArrayList<MemberDto> list = new ArrayList<>();
		
		if(id.equals("aaa")) {
			map.put("result", "fail");     //사용 불가능
		}else{
			map.put("result", "success");  //사용 가능
		}
		
		//JSONArray jarr = new JSONArray();
		//JSONObject jObj = new JSONObject();
		//▶ JSON 포맷 자동 변환: Map,List
		
		map.put("mdto", new MemberDto("ccc","1111","이순신","010","Female","game,golf",new Timestamp(System.currentTimeMillis())));
		map.put("mdto", new MemberDto("ddd","1111","강감찬","010","Female","game,golf",new Timestamp(System.currentTimeMillis())));
		map.put("name", "홍길동");
		map.put("phone", "010-1111-1111");
		map.put("bno", 1);
		map.put("list", list);
		map.put("mdto", new MemberDto("bbb","1111","유관순","010","Female","game,golf",new Timestamp(System.currentTimeMillis())));
		
		return map;
	}
	
	
	@RequestMapping("aaa")
	public String aaa() {
		return "aaa"; //aaa.jsp
	}
	
	@ResponseBody //bbb를 데이터(텍스트)로 전달해줘
	@RequestMapping("bbb")
	public String bbb() {
		String txt = "{'id':'aaa','pw':'1111','name':'홍길동'}";
		return txt; 
	}
	
}
