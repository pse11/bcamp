package com.boot.jdbc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.jdbc.model.dto.MyDto;
import com.boot.jdbc.model.mapper.MyBoardMapper;

@Repository
public class MyDaoImpl implements MyDao{

	@Autowired
	private MyBoardMapper mapper;
	
	@Override
	public List<MyDto> selectList() {
		return mapper.selectList();
	}

	@Override
	public MyDto selectOne(int myno) {
		return null;
	}

	@Override
	public int insert(MyDto dto) {
		return 0;
	}

	@Override
	public int update(MyDto dto) {
		return 0;
	}

	@Override
	public int delete(int myno) {
		return 0;
	}

}
