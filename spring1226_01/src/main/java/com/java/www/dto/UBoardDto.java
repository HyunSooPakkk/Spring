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
public class UBoardDto {

	private int u_bno;
	private String id;
	private String u_btype;
	private String u_btitle;
	private String u_bcontent;
	private int u_bprice;
	private String u_blocal;
	private Timestamp u_bdate;
	private int u_bstatus;
	private int u_bhit;
	private String u_bfile;
	
	
	
}//UBoardDto