package com.mvc.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.mvc.dao.MyMVCDao;
import com.mvc.dao.MyMVCDaoImpl;
import com.mvc.dto.MyMVCDto;
public class MyMVCServiceImpl implements MyMVCService {

	private MyMVCDao dao = new MyMVCDaoImpl();
	
	public List<MyMVCDto> selectAll() {
		Connection con = getConnection();
		List<MyMVCDto> list = dao.selectAll(con);
		close(con);
		System.out.println("05.db종료\n");
		return list;
	}

	@Override
	public MyMVCDto selectOne(int seq) {
		Connection con = getConnection();
		MyMVCDto dto = dao.selectOne(con, seq);
		close(con);
		System.out.println("05.db종료\n");
		return dto;
	}

	@Override
	public boolean insert(MyMVCDto dto) {
		return false;
	}

	@Override
	public boolean update(MyMVCDto dto) {
		return false;
	}

	@Override
	public boolean delete(int seq) {
		return false;
	}

}
