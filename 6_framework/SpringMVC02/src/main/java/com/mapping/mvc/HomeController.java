package com.mapping.mvc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapping.mvc.dto.AddressDto;
import com.mapping.mvc.dto.BoardDto;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/command.do" ,method=RequestMethod.GET)
	public String getCommand(Model model,String name, @RequestParam("addr")String address, String phone) {
		
		model.addAttribute("dto", new AddressDto(name,address,phone));
		
		return "getcommand";
	}
	
	@RequestMapping(value="/command.do",method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		
		System.out.println(dto.getName());
		System.out.println(dto.getAddr());
		System.out.println(dto.getPhone());
		model.addAttribute("dto",dto);
		
		return "postCommand";
	}
	
	//[2] board.do요청을 받아 처리하는 메소드 작성
	// 	-입력 받은 값은 BoardDto 객체로 받는다.
	//  -boardres.jsp페이지로 응답하고 입력받은 데이터를 출력해 확인한다.
	@PostMapping("/board.do")
	public String getBoard(Model model,@ModelAttribute BoardDto dto) {
		dto.setRegdate(new Date());
		
		model.addAttribute("dto",dto);
		return "boardres";
		
	}
	
}
