package com.mvc.test.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.test.model.dao.BoardDao;
import com.mvc.test.model.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectAll() {
		return dao.selectAll();
	}

	@Override
	public BoardDto selectOne(int testno) {
		return dao.selectOne(testno);
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int testno) {
		return dao.delete(testno);
	}

	@Override
	@Transactional
	public String test() {
		dao.insert(new BoardDto(0,"tran2","id2","test2","insert2",null));
		String str = dao.test();
		//str.length();
		return null;
	}

}
