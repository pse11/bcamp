package com.model.service;

import java.sql.Connection;
import java.util.List;

import com.model.dao.MemberDaoImpl;
import com.model.dao.Memberdao;
import com.model.dto.Member;
import static common.JDBCTemplate.*;
public class MemberServiecImpl implements MemberService{
	//CONNECTION 객체 만들고 dao호출
	Memberdao dao = new MemberDaoImpl();
	@Override
	public List<Member> selectAll() {
		Connection con = getConnection();
		List<Member> res = dao.selectAll(con);
		close(con);
		return res;
	}

	@Override
	public Member selectOne(int n) {
		Connection con = getConnection();
		Member res = dao.selectOne(con, n);
		close(con);
		return res;
	}

	@Override
	public int insert(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

}
