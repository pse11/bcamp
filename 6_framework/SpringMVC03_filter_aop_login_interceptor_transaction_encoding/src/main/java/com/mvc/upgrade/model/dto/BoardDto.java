package com.mvc.upgrade.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //매개변수 없는 기본생성자 만들어라
@AllArgsConstructor //필드 모두 포함한 생성자 만들어라
//@RequiredArgsConstructor //필드들 중 final 키워드 붙은 필드만 생성자 만듦
@Getter
@Setter
@ToString
//@Data //getter,setter,tostring, hashcode 한번에 동작하는 것
public class BoardDto {
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
}
