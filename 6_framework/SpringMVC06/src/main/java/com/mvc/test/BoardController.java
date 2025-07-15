package com.mvc.test;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.test.model.dto.BoardDto;
import com.mvc.test.model.service.BoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardService service;
	
	
	@RequestMapping("boardlist.do")
	public String boardlist(Model model) {
		logger.info("boardlist");
		List<BoardDto> res = service.selectAll();
		model.addAttribute("list",res);
		return "boardlistpage";
	}
	
	@RequestMapping("detail.do")
	public String detail(int testno, Model model) {
		logger.info("detail");
		BoardDto res = service.selectOne(testno);
		model.addAttribute("dto",res);
		return "boarddetailpage";
	}
	
	@RequestMapping("writeform.do")
	public String writeform(HttpSession session, Model model) {
		logger.info("writeform");
		model.addAttribute("logindto",session.getAttribute("login"));
		return "boardwritepage";
	}
	@RequestMapping("boardwrite.do")
	public String boardwrite(BoardDto dto) {
		logger.info("boardwrite");
		int res = service.insert(dto);
		if(res>0) {
			return "redirect:boardlist.do";
		}else {
			return "redirect:writeform.do";
		}
	}
	@RequestMapping("updateform.do")
	public String updateForm(int testno,Model model) {
		logger.info("updateform");
		BoardDto dto= service.selectOne(testno);
		model.addAttribute("dto",dto);
		return "boardupdatepage";
	}
	
	@RequestMapping("update.do")
	public String update(BoardDto dto) {
		logger.info("update");
		
	}
}
