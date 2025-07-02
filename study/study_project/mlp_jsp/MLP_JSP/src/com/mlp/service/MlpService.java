package com.mlp.service;

import com.mlp.dao.MemberDao;
import com.mlp.dto.MemberDto;

public class MlpService {
	private MemberDao dao = new MemberDao();
	
	public MemberDto login(String id) {
		MemberDto res =null;
		res = dao.login(id);
		
		return res;
	}
}
