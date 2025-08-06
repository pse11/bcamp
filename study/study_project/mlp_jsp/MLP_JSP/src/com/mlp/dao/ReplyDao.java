package com.mlp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mlp.dto.ReplyDto;

public class ReplyDao extends SqlMapConfig{
	public int insert(ReplyDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("com.my.reply.insert",dto);
		return res;
	}
	public List<ReplyDto> selectAll(){
		SqlSession session = null;
		List<ReplyDto> res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.reply.selectAll");
		return res;
	}
	public int update(ReplyDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.my.reply.update",dto);
		return res;
	}
	public int delete(int no) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.delete("com.my.reply.delete",no);
		return res;
	}
}
