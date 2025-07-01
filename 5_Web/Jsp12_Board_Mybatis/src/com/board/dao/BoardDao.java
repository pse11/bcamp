package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardDto;

public class BoardDao extends SqlMapConfig{
	
	//list
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.board.selectAll");
		
		session.close();
		
		return res;
	}
	
	//detail
	public BoardDto selectOne(int seq) {
		SqlSession session = null;
		BoardDto res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne("com.my.board.selectOne",seq);
		
		session.close();
		return res;
	}
	
	//update 
	public int update(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.my.board.update",dto);
		
		if(res>0) {
			session.commit();
		}
		session.close();
		
		return res;
	}
	
	//insert
	public int insert(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.my.board.insert",dto);
		
		if(res>0) {
			session.commit();
		}
		session.close();
		return res;
	}
	
	public int mulDel(String[] seq) {
		SqlSession session = null;
		int res = 0;
		
		Map<String, String[]> map = new HashMap<>();
		map.put("seq", seq);
		
		session = getSqlSessionFactory().openSession(false);
		res = session.delete("com.my.board.muldel",map); 
		
		if(res==seq.length) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return res;
	}
	
	public int delete(int seq) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.delete("com.my.board.delete",seq);
		
		if(res>0) {
			session.commit();
		}
		session.close();
		return res;
		
	}
	
}
