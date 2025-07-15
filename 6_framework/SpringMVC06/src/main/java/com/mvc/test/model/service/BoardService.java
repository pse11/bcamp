package com.mvc.test.model.service;

import java.util.List;

import com.mvc.test.model.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int testno);
	public int insert(BoardDto dto);
}
