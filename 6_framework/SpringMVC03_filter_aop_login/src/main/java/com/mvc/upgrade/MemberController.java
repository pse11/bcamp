package com.mvc.upgrade;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.dto.MemberDto;
import com.mvc.upgrade.model.service.MemberService;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "mvclogin";
	}
	
	@RequestMapping("/ajaxlogin.do")
	@ResponseBody //메서드가 반환(return)하는 객체를 그대로 http응답의 body에 json등으로 변환해 보내라는 뜻. 만약 없으면, 스프링은 반환값을 뷰이름으로 jsp페이지를 찾음.
	public Map<String,Boolean> login(@RequestBody MemberDto dto, HttpSession session) {//클라이언트가 http 요청 본문(body)에 json형태로 보낸 데이터를 스프링이 자동으로 자바 객체(dto)로 변환해줌.
		logger.info("LOGIN");
		
		MemberDto res = service.login(dto);
		
		boolean check = false;
		if(res!=null) {
			check=true;
			session.setAttribute("login",res);
		}
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		System.out.println("check: "+check);
		return map;
	}
}
