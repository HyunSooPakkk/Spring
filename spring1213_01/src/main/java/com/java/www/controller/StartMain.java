package com.java.www.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.www.config.AppConfig;
import com.java.www.service.PService;
import com.java.www.service.PServiceImpl2;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("프로그램을 시작합니다.");
		
		//예전에 이클립스에서 했던 방식
		//1. 실제 객체선언 후 메소드 사용
		//PServiceImpl pServiceimpl = new PServiceImpl();
		//pServiceimpl.execute();
		
		//1-2. ver2 메소드 사용
		//PServiceImpl2 pServiceimpl2 = new PServiceImpl2();
		//pServiceimpl2.execute();
		
		//2. 다형성을 이용한 객체선언 후 메소드 사용
		//PService pService = new PServiceImpl();
		//pService.execute();
		
		//2-2. ver2 메소드 사용
		//PService pService = new PServiceImpl2();
		//pService.execute();
		
		//3.스프링이 직접 객체선언 한 것을 주입(Injection) - xml 설정 주입 
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/www/config/pconfig.xml");
		//PService pService = ctx.getBean("pconfig", PService.class); 
		//pService.execute();		
		
		//3-2.스프링이 직접 객체선언 한 것을 주입(Injection) - java annotation 설정 주입
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppConfig.class);
		PService pService = (PService) ctx2.getBean("pconfig");
		pService.execute();
		
	}

}//StartMain
