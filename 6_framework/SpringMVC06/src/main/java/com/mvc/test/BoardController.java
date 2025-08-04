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
import com.mvc.test.model.dto.MemberDto;
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
	public String updateForm(HttpSession session, int testno,Model model) {
		logger.info("updateform");
		MemberDto logindto = (MemberDto)session.getAttribute("login");
		String loginid = logindto.getMemid();
		BoardDto dto= service.selectOne(testno);
		String boardid=dto.getTestid();
		if(loginid.equals(boardid)||loginid.equals("admin")) {
			model.addAttribute("dto",dto);
			return "boardupdatepage";			
		}else {
			System.out.println("작성자 본인만 수정가능");
			model.addAttribute("testno",testno);
			model.addAttribute("check",true);
			return "forward:detail.do";
		}
	}
	
	@RequestMapping("update.do")
	public String update(BoardDto dto) {
		logger.info("update");
		int res = service.update(dto);
		if(res>0) {
			return "redirect:boardlist.do";
		}else {
			return "redirect:updateform.do";
		}
		
	}
	@RequestMapping("delete.do")
	public String delete(HttpSession session, int testno,Model model) {
		logger.info("delete");
		MemberDto logindto = (MemberDto)session.getAttribute("login");
		BoardDto boarddto = service.selectOne(testno);
		String loginid=logindto.getMemid();
		String boardid=boarddto.getTestid();
		if(loginid.equals(boardid)||loginid.equals("admin")) {
			int res = service.delete(testno);
			if(res>0) {
				return "redirect:boardlist.do";
			}else {
				return "redirect:detail.do";
			}
		}else {
			System.out.println("작성자 본인만 삭제 가능");
			model.addAttribute("testno",testno);
			model.addAttribute("check",true);
			return "forward:detail.do";
		}
	}
	@RequestMapping("/test.do")
	public String test() {
		logger.info("TRANSACTION TEST");
		service.test();
		
		return "redirect:boardlist.do";
	}
}
