package com.collection.part03_map.hashmap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public void test() {
		//properties
		//key, value 모두 String 객체
		
		Properties prop = new Properties();
		prop.setProperty("key","value");
		prop.setProperty("id","admin");
		prop.setProperty("pw", "1234");
		//prop.setProperty("age",12); //value가 String이 아니라서 안됨
		//prop.put("pw", 12); //property보다는 map으로 데이터를 집어넣었다.
		
		System.out.println(prop);
		System.out.println();
		
		String id = prop.getProperty("id");
		String pw = prop.getProperty("pw");
		//int getPw = (int)prop.get("pw"); //억지로 get, put으로 하는건 properties 사용이 아닌 map 사용한 것이다. properties에 옳지 않음
		System.out.println(id+","+pw);
		//System.out.println("getPw: "+getPw);
		
		//외부파일로 출력 가능
		try {
			//.properties파일은 키,값을 구분한다.
			prop.store(new FileOutputStream("driver.properties"), "properties Test"); 
			prop.store(new FileWriter("driver.txt"),"properties Test");
			prop.storeToXML(new FileOutputStream("dr.xml"),("xml stor"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void test2() {
		//파일로부터 읽어오기
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("driver.properties"));
			System.out.println(prop);
			System.out.println(prop.getProperty("name"));
			System.out.println(prop.getProperty("age"));
			System.out.println(prop.getProperty("id"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
