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
public class CppCDto {

	private int cpp_cno;
	private int cpp_bno;
	private String id;
	private String cpp_cpw;
	private String cpp_ccontent;
	private Timestamp cpp_cdate;
	
	
}//CppCDto
