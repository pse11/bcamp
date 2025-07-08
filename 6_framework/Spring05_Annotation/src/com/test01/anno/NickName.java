package com.test01.anno;

import org.springframework.stereotype.Component;

@Component("nick") //해당 클래스 bean으로 만들어진다.
public class NickName {
	@Override
	public String toString() {
		return "lcj";
	}
}
