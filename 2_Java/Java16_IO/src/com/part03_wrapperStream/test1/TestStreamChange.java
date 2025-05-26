package com.part03_wrapperStream.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestStreamChange {
	//보통 기반이 byte이고 보조가 char일 경우 많이 사용
	public void input() {
		//InputStreamReader클래스
		//보조: BufferedReader ->char단위(Reader)
		//기반: System.in, 콘솔창  -> byte 단위
		
		//new 보조스트림(new 보조스트림(다른스트림));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.print("문자열 입력: ");
		String val = br.readLine(); //문자 한 줄 전체를 읽어온다.
		System.out.println("val: "+val);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void output() {
		//OutputStreamWriter클래스
		//보조스트림 : BufferedWriter ,char 단위(Writer) 
		//기반스트림 : System.out ,byte 단위
		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			bw.write("hello hi bye");
			bw.flush(); //버퍼에있는거 밀어냄
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close(); //남아있던거 다 출력
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
