package com.mlp.dao;

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
}
