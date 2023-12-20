package com.java.www.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {

	private int bno;
	private String btitle;
	private String bcont;
	private Timestamp bdate;
	private String id;
	private int bgroup;    //정렬: 답글 달기
	private int bstep;     //답글 순서
	private int bindent;   //들여쓰기
	private int bhit;
	private String bfile;
	
}
