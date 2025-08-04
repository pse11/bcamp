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
	public String postCommand(Model model, @ModelAttribute AddressDto dto) { //@ModelAttribute : 클라이언트가 보낸 요청 파라미터(폼 데이터, 쿼리스트링 등)를 자동으로 객체에 바인딩 해주는 역할.
																			//즉, HTTP 요청에 포함된 데이터(name, addr, phone)를 AddressDto 객체 필드에 자동으로 채워서 넘겨줌.
		
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
