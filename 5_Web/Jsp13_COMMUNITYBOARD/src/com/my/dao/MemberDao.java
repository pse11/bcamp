package com.my.dao;

import org.apache.ibatis.session.SqlSession;

import com.my.dto.MemberDto;

public class MemberDao extends SqlMapConfig{
	
	public MemberDto selectOne(String id) {
		SqlSession session = null;
		MemberDto res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne("com.mp.member.selectOne",id);
		
		session.close();
		
		return res;
	}
	public MemberDto selectOne(int no) {
		SqlSession session = null;
		MemberDto res = null;
		session = getSqlSessionFactory().openSession();
		res = session.selectOne("com.mp.member.selectOneNo",no);
		
		session.close();
		return res;
	}
	public int insert(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("com.mp.member.insert",dto);
		
		session.close();
		return res;
	}
	public int update(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.mp.member.update",dto);
		
		session.close();
		return res;
	}
	
	public int unenable(int no) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.mp.member.unenable",no);
		
		session.close();
		return res;
	}
}
