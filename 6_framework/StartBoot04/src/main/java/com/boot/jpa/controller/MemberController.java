package com.boot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.MemberDao;
import com.boot.jpa.model.entity.MemberEntity;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberEntity> list = dao.findAll(Sort.by(Sort.Direction.DESC,"memberno"));
		
		model.addAttribute("list",list);
		return "memberlist";
	}
	
}
