package com.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hello.service.HelloService;

@Controller	
public class HelloController {
	
	//이제 command 값 안넘겨도됨. 이제 if문 하나하나가 spring mvc에서는 메소드가 될 것이다.
	//private HelloService service = new HelloService();
	@Autowired
	private HelloService service;
	
	@RequestMapping(value="/hello.do")
	public String getHello(Model model) { //Model : 뷰에 데이터를 담아 전달하는 역할을 하는 인터페이스. 컨트롤러 메소드의 매개변수로 선언하면 스프링이 자동으로 전달해준다.
		String res = service.getHello();
		model.addAttribute("msg",res);
		return "/WEB-INF/views/hello.jsp"; //실제 뷰 경로를 전달해줬기 때문에 viewresolver가 경로를 조립하지 않고 dispatcherservlet이 바로 forward
	}
	
	/*@RequestMapping(value="/bye.do")
	public String getBye(@RequestParam("name")String myName) {
		System.out.println(myName);
		return null;
	}*/
	@RequestMapping("/bye.do")
	public ModelAndView getBye(String name) { //파라미터 name값과 매개변수가 같아야 @RequestParam생략할 수 있다., modelandview : 데이터와 view 이름 모두 들어있다.
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("msg","bye, "+name);
		
		return mav;
	}
	
	@RequestMapping("/res.do")
	public ModelAndView getRes(String name, String age) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/res.jsp");
		mav.addObject("msg", "name: "+name+"\nage: "+age);
		
		return mav;
	}
	
//	@RequestMapping("/res.do")
//	public String getRes(String name, int age, Model model) {
//		model.addAttribute("resMsg", name+":"+age);
//		return "/WEB-INF/views/res.jsp";
//	}
	
}
