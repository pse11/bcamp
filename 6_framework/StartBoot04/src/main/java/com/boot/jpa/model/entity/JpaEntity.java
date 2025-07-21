package com.boot.jpa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//Entity는 자바 객체와 데이터베이스 테이블을 연결해주는 클래스.
//@Entity를 붙이면 JPA가 DB테이블과 연결해줌.
@Table(name="MYBOARD")//oracle에서 매핑할 MYBOARD테이블 결정, 만약 클래스 이름과 테이블이름 같게 하면 @Table작성하지 않아도 됨
public class JpaEntity {
	
	//@Id가 기본키 필드를 지정하고,@GeneratedValue는 어떻게 그 기본키를 생성할지 전략을 지정. 
	//주요 전략들 : AUTO(기본값, 알아서 전략 선택), IDENTITY
	@Id //Id :myno가 기본키(primary key)라는 걸 jpa에게 알려줌. 기본키가 없으면 jpa가 엔티티를 제대로 관리할 수 없음.
	@GeneratedValue(strategy=GenerationType.AUTO) //기본키가 자동으로 생성되는 전략을 지정함. JPA에게 기본키 값을 직접 안넣어도돼, 자동으로 만들어서 넣어줘라고 알려주는 것.
	@Column
	private int myno;
	
	@Column(updatable=false) //update구문에서는 이 컬럼은 제외시킨다. insert이런거는 됨
	private String myname;
	@Column
	private String mytitle;
	@Column
	private String mycontent;
	@Column(updatable=false)
	@Temporal(TemporalType.DATE)//TemporalType.DATE: 날짜만 저장. TemporalType.TIME, TIMESTAMP도 작성가능. 
	private Date mydate;
	public JpaEntity() {}
	public JpaEntity(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}

	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public Date getMydate() {
		return mydate;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
}
