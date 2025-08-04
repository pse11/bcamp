package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러로서도 사용하겠다.
@SpringBootApplication
// = @Configuration + @EnableAutoConfiguration + @ComponentScan
// @Configuration : 이 클래스가 설정 클래스라는 뜻. 예전의 applicationContext.xml같은 설정을 자바 코드로 대체 
//					빈 등록할 때 이 클래스 내부에서 설정할 수 있음
//@EnableAutoConfiguration : 자동 설정 기능을 켜준다.
//							spring boot가 classpath에 어떤 라이브러리들이 있는지를 보고, 자동으로 적절한 설정을 해줌.
//						예. spring-boot-start-web이 있다면, 자동으로 tomcat,dispatcherserlvet, webmvcconfigurer등을 설정해줌.
//@ComponentScan : 이 패키지(com.boot.hello)를 기준으로 하위 패키지를 스캔해서,
//					@Component, @Controller, @Service, @Repository등이 붙은 클래스를 찾아서 빈으로 등록.
//					그래서 애플리케이션이 필요한 컴포넌트를 자동으로 사용할 수 있게 됨.
//				예전 xml파일에서 <context:component-scan base-package="패키지 경로"/> 이걸 자바코드에서 사용하는 것.
public class StartBoot01Application {
//관례적으로 spring boot의 시작점 클래스는 'Application'이라고 이름 붙임.
//springBoot01Application.java는 spring boot 프로젝트의 시작점이자, 설정 자동화 + 빈 스캔 + 서버 실행을 시작하는 역할만 하는 클래스!!!
	
	public static void main(String[] args) {
		SpringApplication.run(StartBoot01Application.class, args);//run이라고하는 메소드가 실행되면서 spring boot어플리케이션이 돌아간다.
		//run이 핵심. run호출되면서 springboot 동작
		//내부적으로 spring 컨테이너(ApplicationContext)를 만들고, 자동 설정, 컴포넌트 스캔, 내장 웹 서버 실행 등 모든 걸 처리.
		/*
		 * 작동 과정 요약:
		 * 1. tartBoot01Application.class 는 이 클래스 자체를 의미
		 * 2. 'args'는 실행 시 전달받은 매개변수.
		 * 3. 'run()'메소드가 호출되면, 
		 * 	- SpringApplication 인스턴스를 생성하고,
		 * 	- 애플리케이션 컨텍스트를 초기화하고,
		 * 	- 자동 설정을 수행하고,
		 * 	- 필요한 bean들을 스캔하고 등록하고,
		 * 	- 최종적으로 내장 웹 서버(tomcat등)를 실행. 
		 */
	}
	
	//테스트 용으로 컨트롤러 만든것. 원래는 따로 컨트롤러 클래스 만들어야함.
	@GetMapping("/hello")
	public String hello() {
		System.out.println("controller hello method");
		return "test"; //페이지 
	}

}
