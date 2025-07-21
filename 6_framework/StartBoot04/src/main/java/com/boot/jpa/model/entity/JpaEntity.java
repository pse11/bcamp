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
	
	@Id //Id :myno가 기본키이다.
	@GeneratedValue(strategy=GenerationType.AUTO) //
	@Column
	private int myno;
	
	@Column(updatable=false) //update구문에서는 이 컬럼은 제외시킨다. insert이런거는 됨
	private String myname;
	@Column
	private String mytitle;
	@Column
	private String mycontent;
	@Column(updatable=false)
	@Temporal(TemporalType.DATE)//TemporalType.TIME, TIMESTAMP도 작성가능. 
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
