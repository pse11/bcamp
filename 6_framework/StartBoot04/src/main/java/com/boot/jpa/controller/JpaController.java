package com.boot.jpa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.entity.JpaEntity;

@Controller
@RequestMapping("/board") //board로 시작하는 요청은 이 컨트롤러가 처리한다.
public class JpaController {
	
	@Autowired 
	private JpaDao dao;
	
	@GetMapping("/list")
	public String selectAll(Model model) {
		System.out.println("[list]");
		
		//List<JpaEntity> list = dao.findAll(); //JPA가 제공하는 findAll()메서드를 호출해서 테이블의 모든 행을 자바 객체 리스트로 가져온다.
		List<JpaEntity> list = dao.findAll(Sort.by(Sort.Direction.DESC,"myno"));
		
		model.addAttribute("list",list);
		return "jpalist";
	}
	
	@GetMapping("/detail")
	public String selectOne(int myno, Model model) {
		System.out.println("[detail]");
		
		JpaEntity dto = dao.findByMyno(myno);
		//findBy필드이름 : 필드 이름을 기반으로 조회
		
		model.addAttribute("dto",dto);
			
		return "jpadetail";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		System.out.println("[insertForm]");
		return "jpainsert";
	}
	
	@PostMapping("/insert")
	public String insert(JpaEntity dto) {
		System.out.println("[insert]");
		dto.setMydate(new Date());
		JpaEntity res = dao.save(dto);
		
		System.out.println(res.getMyno());//변경되려고하는 값들이 채워져 있는 상황에서 pk값 포함해서 저장해놓고 있다. 엔티티 객체 내부에 변경된 값들을 다 채워넣고 있다.
		System.out.println(res.getMyname());
		
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String updateForm(int myno, Model model) {
		System.out.println("[updateform]");
		model.addAttribute("dto",dao.findByMyno(myno));
		return "jpaupdate";
	}
	
	@PostMapping("/update")
	public String update(JpaEntity dto) {
		System.out.println("[update]");

		dao.save(dto);
		//jpa에서 save()=> insert or update 작업을 진행한다.
		//id가 null=> insert 실행
		//id가 존재, db에 id와 일치하는 데이터 존=> update 실행
		
		return "redirect:/board/detail?myno="+dto.getMyno();
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		System.out.println("[delete]");
		
		//dao.deleteById(myno);
		dao.deleteByMyno(myno);
		
		return "redirect:/board/list";
	}
}
