package com.java.www.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class AppConfig {

	@Bean //객체를 하나 만들어서 리턴한다
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		//MyBatis에 있는 session 연결 - application.properties에서 정보를 가져와 DB의 dataSource를 가져옴
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		//Query문이 담긴 mapper 파일을 모두 가져옴
		Resource[] res = new PathMatchingResourcePatternResolver().getResources(
				"classpath:/mapper/**/*.xml" //**: 모든 폴더 확인 
				);
		sessionFactory.setMapperLocations(res);
		
		return sessionFactory.getObject();  //MyBatis DB+mapper 정보가 들어가있는 모든 객체 가져다줘
	}
	
	
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory); //MyBatis에 사용할 1개 객체 가져다줘
	}
	
}
