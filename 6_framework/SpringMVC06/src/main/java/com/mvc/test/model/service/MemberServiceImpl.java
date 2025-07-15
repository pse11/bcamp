package com.mvc.test.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.test.model.dao.MemberDao;
import com.mvc.test.model.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;
	@Override
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}

}
