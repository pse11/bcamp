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
	
	//findBy필드명 형태로 작성하면, spring data jpa가 자동으로 JPQL생성
	//JPQL : JPA에서 사용하는 객체 지향 쿼리 언어. SQL과 비슷하게 생겼지만, 테이블이 아니라 엔티티를 대상으로 작동
	//		테이블 대신 클래스, 컬럼 대신 필드명 씀
	//JpaEntity 안에 myno, myname이라는 필드가 반드시 존재해야함.
	public JpaEntity findByMyno(int myno);
	
	public JpaEntity findByMyname(String myname);
	
	//public JpaEntity save(JpaEntity dto);
	
	//public JpaEntity update(JpaEntity dto); 이건 안됨=> update()라는 이름의 메서드는 자동 구현 X, save() 메서드가 insert, update 모두 처리
	
	//deleteBy필드명 도 자동으로 구현됨.
	//@Transactional : delete 작업은 변경이기 때문에 트랜잭션 안에서 실행되어야함.
	//보통 @Service나 @Repository단에서 전체적으로 처리하기도 함.
	@Transactional
	public void deleteByMyno(int myno);
	
}
