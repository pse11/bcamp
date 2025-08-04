package com.mvc.test.model.dao;

import com.mvc.test.model.dto.MemberDto;

public interface MemberDao {
	public MemberDto login(MemberDto dto);
	public int insert(MemberDto dto);
	
}
