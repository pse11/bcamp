package com.test.chap02_class.publicClassTest.run;

import com.test.chap02_class.publicClassTest.model.*;
public class Run {

	public static void main(String[] args) {
		//객체 생성
		//test()실행
		PublicClassTest t = new PublicClassTest(); //다른 패키지에 있기 때문에 import 해줘야한다.
		t.test();
		
	}

}
