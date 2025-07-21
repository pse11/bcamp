package com.boot.jpa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.MemberDao;
import com.boot.jpa.model.entity.MemberEntity;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	@GetMapping("/loginform")
	public String loginForm() {
		System.out.println("login form");
		return "memberlogin";
	}
	
	@PostMapping("/login")
	public String login(String memberid, String memberpw,HttpSession session) {
		MemberEntity dto = dao.findByMemberidAndMemberpw(memberid, memberpw);
		
		if(dto!=null) {
			session.setAttribute("login", dto);
			return "redirect:/board/list";
		}else {
			return "redirect:/member/loginform";
		}
		
	}
	@GetMapping("/registform")
	public String registForm() {
		return "memberregist";
	}
	
	@PostMapping("/regist")
	public String regist(MemberEntity dto) {
		dao.save(dto);
		return "redirect:/member/loginform";
	}
	@GetMapping("/mypage")
	public String mypage(Model model,HttpSession session) {
		model.addAttribute("dto",session.getAttribute("login"));
		return "mypage";
	}
	
	@GetMapping("/updateform")
	public String updateForm(int memberno, Model model) {
		MemberEntity dto = dao.findByMemberno(memberno);
		model.addAttribute("dto",dto);
		return "memberupdate";
	}
	
	@PostMapping("/update")
	public String update(MemberEntity dto) {
		dao.save(dto);
		
		return "redirect:/board/list";
	}
}
