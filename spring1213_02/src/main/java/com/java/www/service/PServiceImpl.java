package com.java.www.service;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//@Component
@Service
public class PServiceImpl implements PService {

	@Override
	public void execute() {
		System.out.println("[Service 버전 1]을 호출합니다.");

	}

}
