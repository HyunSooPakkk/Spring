package com.java.www.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired
	BService bService;
	
	@RequestMapping("bList")
	public String bList(Model model) {
		
		ArrayList<BoardDto> list = bService.selectAll();
		
		model.addAttribute("list", list);
		System.out.println("list개수: "+list.size());
		
		return "board/bList";
	}
	
	@GetMapping("bView") 
	public String bView(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("BController bno: "+bno);
		Map<String, Object> map = bService.selectOne(bno);
		model.addAttribute("map",map);
		
		return "board/bView";
	}
	
	@RequestMapping("bInsert")
	public String bInsert() {
		return "board/bInsert";
	}
	
	@RequestMapping("doBInsert")
	public String doBInsert(BoardDto bdto, @RequestPart MultipartFile files, Model model) throws Exception {
		if(!files.isEmpty()) {
			String orgName = files.getOriginalFilename();
			System.out.println("BController 파일 첨부 이름: "+orgName);
			long time = System.currentTimeMillis();
			String newName = time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		}else {
			bdto.setBfile("");
			System.out.println("파일첨부가 없습니다.");
		}
		//DB로 전송
		bService.bInsert(bdto);
		
		return "board/doBInsert";
	}
	
	
	
	
}//BController
