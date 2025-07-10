package com.mlp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mlp.dto.BoardDto;

public class BoardDao extends SqlMapConfig{
	
	public int insertFeed(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.insert("com.my.board.insertFeed",dto);
		
		session.close();
		return res;
	}
	
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.board.selectAll");
		
		session.close();
		return res;
	}
}
