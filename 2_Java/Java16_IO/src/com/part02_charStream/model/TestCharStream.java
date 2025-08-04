package com.part02_charStream.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharStream {
	public void filesave() {
		//문자단위의 기반스트림
		//FileWriter
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("sample2.txt",true);//생성자에 true 넣으면 내용을 덮어씌우는것이 아닌 이어서 붙이게 된다.
			//파일이 존재하지 않으면 자동 생성한다.
			
			fw.write("안녕하세요 반가워요");
			fw.write('A');
			char[] carr = {'a','p','p','l','e'};
			fw.write(carr);
			fw.write("\n");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {				
			fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void fileopen() {
		//문자 기반 스트림
		//FileReader 이용
		FileReader fr = null;
		
		try {
			fr= new FileReader("sample2.txt");
//			System.out.println((char)fr.read());
//			System.out.println((char)fr.read());
			
			int val;
			while((val=fr.read())!=-1) {
				System.out.print((char)val);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//new 기반스트림("외부자원");
	//new 보조스트림(new 다른스트림()); //다른스트림:또 다른 보조스트림 or 기반스트림
	//new 보조스트림(new 보조스트림(new 다른스트림()));
	//new 보조스트림(new 기반스트림("외부자원"));
	
	
	
	
}
