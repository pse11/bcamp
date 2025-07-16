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
	
	public List<BoardDto> order(String orderby){
		SqlSession session = null;
		List<BoardDto> res = null;
		System.out.println(orderby);
		session = getSqlSessionFactory().openSession(true);
		if(orderby.equals("DESC")) {
			res = session.selectList("com.my.board.orderbyDesc");			
		}else if(orderby.equals("ASC")) {
			res = session.selectList("com.my.board.orderbyAsc");			
		}
		
		session.close();
		return res;
	}
	public BoardDto selectBoard(int boardno) {
		SqlSession session = null;
		BoardDto res = null;
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne("com.my.board.selectOne",boardno);
		session.close();
		return res;
	}
	
	public int update(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update("com.my.board.update",dto);
		session.close();
		return res;
	}
	
	public List<BoardDto> search(String feedsearch){
		SqlSession session = null;
		List<BoardDto> res = null;
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.board.search",feedsearch);
		session.close();
		return res;
	}
}
