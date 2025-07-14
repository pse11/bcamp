package com.mvc.rest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.rest.model.dao.RestDao;
import com.mvc.rest.model.dto.RestDto;

@Service
public class RestServiceImpl implements RestService{

	@Autowired
	private RestDao dao;
	
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
