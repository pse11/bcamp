package com.mvc.rest.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.rest.model.dto.RestDto;

@Repository
public class RestDaoImpl implements RestDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<RestDto> selectList() {
		return null;
	}

	@Override
	public RestDto selectOne(int restno) {
		return null;
	}

	@Override
	public int insert(RestDto dto) {
		return 0;
	}

	@Override
	public int update(RestDto dto) {
		return 0;
	}

	@Override
	public int delete(int restno) {
		return 0;
	}

}
