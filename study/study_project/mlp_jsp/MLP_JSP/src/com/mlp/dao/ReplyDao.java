package com.mlp.dao;

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
}
