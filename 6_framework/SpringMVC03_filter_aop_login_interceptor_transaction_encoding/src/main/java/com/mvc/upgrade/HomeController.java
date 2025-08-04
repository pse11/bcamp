package com.mvc.upgrade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.dto.BoardDto;
import com.mvc.upgrade.model.service.BoardService;

@Controller
//@RequestMapping("/myboard") 이렇게 하면 요청할 때 "/myboard/list.do"이런식으로 실행할 수 있음. controller가 여러개 일때 사용
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		logger.info("SELECT LIST");
		
		List<BoardDto> res = service.selectList();
		model.addAttribute("list", res);
		return "mvclist";
	}
	
	@RequestMapping("/detail.do")
	public String detail(int myno, Model model) {
		logger.info("SELECT ONE");
		
		BoardDto res = service.selectOne(myno);
		model.addAttribute("dto",res);
		return "mvcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	@RequestMapping("insert.do")
	public String insert(BoardDto dto) {
		logger.info("INSERT");
		int res = service.insert(dto);
		if(res>0) {
			return "redirect:list.do";//handlermapping동작하면서 이전에 list.do요청을 다시 처리			
		}else {
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping("updateform.do")
	public String updateForm(int myno,Model model) {
		logger.info("UPDATE FORM");
		
		BoardDto res = service.selectOne(myno);
		model.addAttribute("dto",res);
		return "mvcupdate";
	}
	
	@RequestMapping("/update.do")
	public String update(int myno, String mytitle, String mycontent) {
		logger.info("UPDATE");
		
		BoardDto dto = new BoardDto();
		dto.setMyno(myno);;
		dto.setMytitle(mytitle);
		dto.setMycontent(mycontent);
		
		int res = service.update(dto);
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:updateform.do";
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(int myno) {
		logger.info("DELETE");
		
		int res = service.delete(myno);
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:detail.do?myno="+myno;
		}
	}
	
	@RequestMapping("/test.do")
	public String test() {
		logger.info("TRANSACTION TEST");
		service.test();
		
		return "redirect:list.do";
	}
	
}
