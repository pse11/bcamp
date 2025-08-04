package com.board.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	//mybatis에서 sqlsessionfactory를 만드는 클래스
	// db에 연결할 준비를 담당하는 단계
	//mybatis에서 db 작업을 하려면 반드시 sqlsession이 필요.
	//sqlsession을 만들려면 sqlsessionfactory가 필요
	private SqlSessionFactory sqlSessionFactory;
	public SqlSessionFactory getSqlSessionFactory() {
		try {
			Reader reader = Resources.getResourceAsReader("db/board_config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//이렇게 만들어진 sqlsessionfactory는 db커넥션 풀, 트랜잭션 설정, mapper 등록 정보 등을 모두 알고 있어서
			//앞으로 opensession()을 호출해서 db작업 기반이 된다.
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
