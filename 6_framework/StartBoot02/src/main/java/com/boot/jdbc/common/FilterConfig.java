package com.boot.jdbc.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<Filter> checkFilter(){
		//FilterRegistrationBean<T extends Filter>은 필터를 Spring Boot에 등록하기 위한 클래스.
		//이를 통해 필터를 프로그래밍적으로 등록하고, 적용할 URL 패턴, 순서, 이름등을 지정할 수 있다.
		
		//1. 필터 등록 객체 생성
		//어떤 필터를 등록할건지(setFilter()),를 Spring에게 registrationBean을 통해 알려줌. 
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<Filter>();
		
		//2.익명 클래스로 필터 구현 및 등록 
		registrationBean.setFilter(new Filter() {

			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				//필터에서 처리하고자 하는 내용
				System.out.println("🚀필터 실행!");
				chain.doFilter(request,response);
			}
		});
		
		registrationBean.addUrlPatterns("/myboard/*"); //필터를 적용할 경로
		
		return registrationBean;
		
	}
}
