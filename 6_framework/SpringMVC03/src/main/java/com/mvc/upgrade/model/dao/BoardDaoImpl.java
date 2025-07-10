package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<>();
		try {
			list = sqlSession.selectList("myboard.selectList");
		} catch (Exception e) {
			System.out.println("[error] select list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		// namespace: myboard
		// id: selectOne
		// SELECT * FROM MYBOARD WHERE MYNO=#{myno}
		
		//dao, mapper 작성
		BoardDto dto = null;
		
		try {
			dto = sqlSession.selectOne("myboard.selectOne",myno);
		}catch (Exception e) {
			System.out.println("[error] select one");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert("myboard.insert",dto);
		} catch (Exception e) {
			System.out.println("[error] insert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.update("myboard.update",dto);
		} catch (Exception e) {
			System.out.println("[error] update");
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		try {
			res = sqlSession.delete("myboard.delete",myno);
		}catch(Exception e) {
			System.out.println("[error] delete");
			e.printStackTrace();
		}
		return res;
	}

}
