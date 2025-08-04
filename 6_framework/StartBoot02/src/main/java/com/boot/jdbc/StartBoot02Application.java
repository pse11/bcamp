package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class StartBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot02Application.class, args);
	}
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	//RequestMapping()이 설정이 없으면 static 폴더에서 index.jsp찾아서 실행.
	
}
