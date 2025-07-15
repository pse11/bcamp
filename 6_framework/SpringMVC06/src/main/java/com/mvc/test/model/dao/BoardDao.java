package com.mvc.test.model.dao;

import java.util.List;

import com.mvc.test.model.dto.BoardDto;

public interface BoardDao {
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int testno);
	public int insert(BoardDto dto);
	
}
