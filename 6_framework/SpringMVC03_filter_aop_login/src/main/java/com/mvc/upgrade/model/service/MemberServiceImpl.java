package com.mvc.upgrade.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MemberDao;
import com.mvc.upgrade.model.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;
	
	@Override
	public MemberDto login(MemberDto dto) {
		
		return dao.login(dto);
	}

}
