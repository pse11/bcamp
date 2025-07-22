package com.boot.jpa.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.jpa.model.entity.MemberEntity;

public interface MemberDao extends JpaRepository<MemberEntity,Integer>{
	
	//id와 pw가 같은 데이터 조회
	public MemberEntity findByMemberidAndMemberpw(String memberid, String memberpw);

	public MemberEntity findByMemberno(int memberno);
	
	@Query("SELECT m FROM MemberEntity m ORDER BY m.memberno DESC") //java단이기 때문에 jpql로 작성해줘야한다.
	public List<MemberEntity> selectAll();
}
