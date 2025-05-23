package com.chap05_date.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Run {
/*
 * Date : 기준 1970년 1월 1일 0시 0분 0초, ms단위
 * Calendar
 * GregorianCalendar
 * - java.util 패키지
 */
	public static void main(String[] args) {
		Date oriTime = new Date(0);
		System.out.println(oriTime);
		oriTime = new Date(1000L); //최초 셋팅값에서 1초 흐른 시간
		System.out.println(oriTime);
		System.out.println(oriTime.toGMTString());//그리니치
				
		Date toDay = new Date();
		
		//원하는 패턴으로 출력
		//SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		System.out.println(sdf.format(toDay));
		
		System.out.println("-----------------캘린더---------------");
		//월은 -1 해서 관리한다.
		//필드넘버 개념
		
		Calendar calendar = Calendar.getInstance();//protected:같은패키지안, 상속시엔 해당패키지까지
		System.out.println(calendar); //실제 객체: gregoriancalendar
		
		//수정
		calendar.set(2022,2-1,22);
		System.out.println(calendar);
		
		int year = calendar.get(1);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		
		System.out.println(year+"년 "+month+"월 "+date+"일");
		
		//SimpleDateformat
		System.out.println(calendar.getTime());
		System.out.println(calendar.getTimeInMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sd.format(calendar.getTime()));
		
		sd.setTimeZone(TimeZone.getTimeZone("Etc/Greenwich")); //지역별 시간
		System.out.println(sd.format(calendar.getTime()));
		
//		for(String name: TimeZone.getAvailableIDs()) {
//			System.out.println(name); //지역들
//		}
		
		System.out.println("---------그레고리안");
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
		
		System.out.println(gc.get(GregorianCalendar.YEAR));
		System.out.println(gc.get(Calendar.HOUR_OF_DAY));
		
		//윤년인지 확인
		System.out.println(gc.isLeapYear(2024));
		
		
	}

}

