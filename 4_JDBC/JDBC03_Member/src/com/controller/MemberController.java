package com.controller;

import java.util.List;

import com.model.dto.Member;
import com.model.service.MemberService;
import com.model.service.MemberServiecImpl;

public class MemberController {
	MemberService service = new MemberServiecImpl();
	public List<Member> selectAll(){
		return service.selectAll();
	}
	public Member selectOne(int n) {
		return service.selectOne(n);
	}
	public int insert(Member dto) {
		return service.insert(dto);
	}
}
