package com.java.www.service;

import org.springframework.stereotype.Component;

@Component //IoC 컨테이너로부터 객체선언 자동으로 해주는 역할
public class PServiceImpl implements PService {

	@Override
	public void execute() {
		System.out.println("1B 연필로 그림을 그립니다.");
		
	}

}
