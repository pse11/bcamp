package com.mvc.test.model.service;

import com.mvc.test.model.dto.MemberDto;

public interface MemberService {
	public MemberDto login(MemberDto dto);
	public int insert(MemberDto dto);
}
