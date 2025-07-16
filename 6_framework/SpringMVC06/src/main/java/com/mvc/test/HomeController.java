package com.mvc.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.test.model.dto.MemberDto;
import com.mvc.test.model.service.MemberService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/loginform.do")
	public String loginform() {
		 logger.info("===================== loginform controller called =====================");
		logger.info("login form");
		return "loginpage";
	}
	
	@RequestMapping("/ajaxlogin.do")
	@ResponseBody
	public Map<String,Boolean> ajaxlogin(@RequestBody MemberDto dto, HttpSession session ) {
		logger.info("ajax login");
		MemberDto res = service.login(dto);
		boolean check = false;
		if(res!=null) {
			if(passwordEncoder.matches(dto.getMempw(), res.getMempw())) {
				check=true;
				session.setAttribute("login",res );
			}
			
		}
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		map.put("check",check);
		System.out.println("check:"+check);
		return map;
	}
	
	@RequestMapping("/registform.do")
	public String registform() {
		logger.info("regist form");
		return "registpage";
	}
	@RequestMapping("/regist.do")
	public String regist(MemberDto dto) {
		logger.info("regist form");
		System.out.println("before pw: "+dto.getMempw());
		String encode = passwordEncoder.encode(dto.getMempw());
		dto.setMempw(encode);
		System.out.println("after pw: "+dto.getMempw());
		
		int res = service.insert(dto);
		if(res>0) {
			return "redirect:loginform.do";
		}else {
			return "redirect:registform.do";
		}
	}
}
