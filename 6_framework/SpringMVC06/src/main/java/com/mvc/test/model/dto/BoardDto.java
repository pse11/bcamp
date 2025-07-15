package com.mvc.test.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardDto {
	private int testno;
	private String testname;
	private String testtitle;
	private String testcontent;
	private Date testdate;
}
