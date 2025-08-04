package com.part03_wrapperStream.test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBuffered {
	public void output() {
		//보조스트림은 단독으로 사용 불가
		//반드시 기반스트림이 필요
		
		BufferedWriter bw = null;
		
		try {
			//new 보조스트림(new 기반스트림("외부자원"));
			bw = new BufferedWriter(new FileWriter("sample3.txt"));
			
			bw.write("안녕하세요\n");
			bw.write("안녕하세요\n");
			bw.write("안녕하세요\n");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}	
	}
	public void input() {
		//1. BufferedReader를 이용하여 스트림을 생성(sample.txt파일과 스트림 생성)
		//2. 해당 파일에 저장된 내용을 readLine()을 이용하여 읽어와서 콘솔에 출력한다.
		//3. 사용이 끝난 스트림 close() 처리 한다.
		BufferedReader br=null;
		try {
			 br = new BufferedReader(new FileReader("sample3.txt"));
			 String tmp = null;
			 while((tmp=br.readLine())!=null) {
				 System.out.println(tmp);
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
