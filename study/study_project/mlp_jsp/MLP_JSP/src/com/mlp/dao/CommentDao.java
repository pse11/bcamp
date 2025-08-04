package com.mlp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mlp.dto.CommentDto;

public class CommentDao extends SqlMapConfig{

	public int insert(CommentDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("com.my.comment.insert",dto);
		
		session.close();
		return res;
	}
	
	public List<CommentDto> selectAll(){
		SqlSession session = null;
		List<CommentDto> res = null;
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.comment.selectAll");
		session.close();
		return res;
	}
	public int update(CommentDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.my.comment.update",dto);
		session.close();
		return res;
		
	}
	public int delete(int no) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.delete("com.my.comment.delete",no);
		session.close();
		return res;
		
	}
}
