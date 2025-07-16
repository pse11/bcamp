package com.mvc.test.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.test.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectAll() {
		List<BoardDto> list = new ArrayList<>();
		try {
			list = sqlSession.selectList("testboard.selectAll");
		} catch (Exception e) {
			System.out.println("[error] select list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int testno) {
		BoardDto res = null;
		try {
		 res = sqlSession.selectOne("testboard.selectOne",testno);
		}catch(Exception e) {
			System.out.println("[error] select one");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert("testboard.insert",dto);
		}catch(Exception e) {
			System.out.println("[error] insert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.update("testboard.update",dto);
		}catch(Exception e) {
			System.out.println("[error] update");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int testno) {
		int res = 0;
		try {
			res = sqlSession.delete("testboard.delete",testno);
		}catch(Exception e) {
			System.out.println("[error] delete");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

}
