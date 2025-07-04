package com.test01.abstract_test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {
	public abstract String dayInfo();
	
	public static AbstractTest getInstance() {
		//객체를 못만드니 static, getInstance를 통해서 얘를 상속받은 자식 클래스 리턴해준다.
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);//1:일요일, 7:토요일
		
		switch(day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Thursday();
		case 5: return new Friday();
		case 6: return new Saturday();
		}
		return null;
	}
}
