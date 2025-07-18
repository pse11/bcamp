package com.boot.leaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.dto.LeafDto;

@Controller
public class LeafController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("[hello]");
		model.addAttribute("name","Thymeleaf!!");
		return "hello"; //thymeleaf여서 viewresolver가 templates에서 hello 페이지를 찾는다.
	}
	
	@GetMapping("/util")
	public String util() {
		return "utility";
	}
	
	@GetMapping("/expr")
	public String expression(Model model) {
		model.addAttribute("name","Thymeleaf");
		model.addAttribute("dto",new LeafDto("Java",22));
		
		List<LeafDto> list = new ArrayList<>();
		list.add(new LeafDto("SpringBoot",33));
		list.add(new LeafDto("DataBase",7));
		list.add(new LeafDto("HTML",25));
		model.addAttribute("list",list);
		return "expression";
	}
	
	@GetMapping("/params")
	public String params(HttpSession session) {
		session.setAttribute("id", "sessionValue");
		return "params";
	}
	
	@GetMapping("/static")
	public String staticTest() {
		return "static";
	}
}
