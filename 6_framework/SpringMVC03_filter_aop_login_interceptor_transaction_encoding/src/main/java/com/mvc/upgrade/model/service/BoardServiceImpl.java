package com.mvc.upgrade.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
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
	public int delete(int myno) {
		return dao.delete(myno);
	}

	@Override
	@Transactional
	public String test() { //이 내부가 트랜잭션으로 동작
		//1. insert 실행
		//     -> 아직 db에 영구 기록된 게아님 (commit 안됨)
		dao.insert(new BoardDto(0,"tran2","test2","insert2",null));
		String str = dao.test();
		
		//2. 여기서 null.length()하면 nullpointerror
		//-> 트랜잭션 rollback
		//-> test() 전체가 트랜잭션으로 묶여있기 때문에 위의 insert도 rollback돼서 db에는 아무것도 안남음ㄴ
		//null.length() ==> insert 후 문제 발생
		
		//str.length();
		
		return null;
	}
}
