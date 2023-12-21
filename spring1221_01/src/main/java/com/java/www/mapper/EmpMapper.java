package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.EmpDeptDto;
import com.java.www.dto.EmpDto;

@Mapper
public interface EmpMapper {
	
	//사원번호 가져오기
	ArrayList<EmpDto> list();
	
	//사원부서정보 가져오기
	ArrayList<EmpDeptDto> list2();

}
