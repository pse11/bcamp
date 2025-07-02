package com.mlp.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mlp.dto.MemberDto;

public class MemberDao extends SqlMapConfig{
	
	public MemberDto login(String id) {
		SqlSession session = null;
		MemberDto res = null;
	
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne("com.my.member.selectLogin",id);
		
		session.close();
		return res;
	}
	public int updateProfile(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.my.member.updateProfile",dto);
		session.close();
		return res;
	}
}
