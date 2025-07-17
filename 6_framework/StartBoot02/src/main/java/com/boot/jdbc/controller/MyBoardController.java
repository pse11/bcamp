package com.boot.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;

@Controller
@RequestMapping("/myboard") //요청이 /myboard인 경우에만 이 컨트롤러 클래스가 처리.
public class MyBoardController {
	
	@Autowired
	private MyBiz biz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		System.out.println("[selectList]");
		List<MyDto> res = biz.selectList();
		model.addAttribute("list",res);
		return "myboardlist";
	}
	
	@GetMapping("/detail")
	public String selectOne(int myno,Model model) {
		System.out.println("[selectOne]");
		MyDto res= biz.selectOne(myno);
		model.addAttribute("dto",res);
		return "myboarddetail";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		System.out.println("[insertform]");
		return "myboardinsert";
	}
	
	@PostMapping("/insert")
	public String insert(MyDto dto) {
		int res = biz.insert(dto);
		if(res>0) {
			return "redirect:/myboard/list";//지금은 컨트롤러가 하나라 myboard안적어도 괜찮지만 myboard도 작성해주는게 원칙임.
		}else {
			return "redirect:/myboard/insertform";
		}
	}
	
	//[1]
	// '/board/updateform' 요청을 처리하는 메소드 추가
	// 수정하려는 게시글 하나를 db로 부터 select후
	// myboardupdate.jsp로 응답
	@GetMapping("/updateform")
	public String updateForm(int myno,Model model) {
		MyDto res = biz.selectOne(myno);
		model.addAttribute("dto",res);
		return "myboardupdate";
	}
	//[2]
	// '/board/update' 요청을 처리하는 메소드 추가
	// myboardupdate.jsp 페이지에서 입력된 수정할 내용을 통해 db update 진행
	// UPDATE MYBOARD SET MYTITLE=#{mytitle}, MYCONTENT=#{mycontent} WHERE MYNO=#{myno}
	// 성공 시 list페이지로, 실패 시 update페이지로 응답.
	@PostMapping("/update")
	public String update(MyDto dto) {
		int res = biz.update(dto);
		if(res>0) {
			return "redirect:/myboard/list";
		}else {
			return "redirect:/myboard/updateform?myno="+dto.getMyno();
		}
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		if(biz.delete(myno)>0) {
			return "redirect:/myboard/list";
		}else {
			return "redirect:/myboard/detail?myno="+myno;
		}
	}
}
