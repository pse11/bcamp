package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.entity.JpaEntity;

//JpaRepository를 상속하면 CRUD 기능을 갖춘 DAO가 자동으로 만들어짐. 
//=> findAll(), save(), findById(), delete() 다 쓸 수 있음 -> SQL 직접 안써도됨
public interface JpaDao extends JpaRepository<JpaEntity, Integer>{ //이 DAO 가 다룰 entity클래스, @id값(기본키)의 타입
	//findAll(), save(), findById(), delete() 과 같은 메소드가 이미 있어 쿼리문을 직접 작성하지 않고 작업을 수월하게 진행할 수 있다.
	
	public List<JpaEntity> findAll(); //이미 있는 메소드지만, 명시적으로 선언. 안써도 상관없음.
	
	public JpaEntity findByMyno(int myno);
	
	public JpaEntity findByMyname(String myname);
	
	//public JpaEntity save(JpaEntity dto);
	
	//public JpaEntity update(JpaEntity dto); 이건 안됨
	
	@Transactional
	public void deleteByMyno(int myno);
	
}
