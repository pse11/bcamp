package com.boot.jpa.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.entity.MemberEntity;

public interface MemberDao extends JpaRepository<MemberEntity,Integer>{
	
	//id와 pw가 같은 데이터 조회
	public MemberEntity findByMyidAndMypw(String myid, String mypw);

}
