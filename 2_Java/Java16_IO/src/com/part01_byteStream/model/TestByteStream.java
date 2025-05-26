package com.part01_byteStream.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByteStream {
	public void filesave() {
		//byte단위로 데이터를 출력할 수 있는 스트림
		//FileOutputStream
		
		//스트림 생성
		FileOutputStream fout=null;
		try{
			fout = new FileOutputStream("sample.txt");
			//대상파일(외부자원,sample.txt) 존재하지 않아 자동으로 생성
			
			//출력 작업
			//fout.write('a');
			fout.write(97); //생성한 txt에 a 적힌다.
			byte[] barr = {98,99,100,101,102,10}; //txt에  abcdef 덮어씌운다.적힌다. 마지막 10은 줄바꿈 의미
			fout.write(barr);
			fout.write(barr,1,3); //barr 인덱스 1부터 3개
			
			//fout.close();  //예외 발생시 close안하고 건너띈다. 그래서 연결이 계속 살아있어서 문제가 된다. => finally에 작성
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fout.close();				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void fileopen() {
		//파일로부터 byte단위로 데이터를 읽어올 수 있는 스트림
		//FileInputStream
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("sample.txt");
			
//			int fileSize = (int)new File("sample.txt").length();
//			System.out.println(fileSize);
//			//파일의 크기만큼의 배열 선언
//			byte[] barr = new byte[fileSize];
//			fin.read(barr);
//			
//			//배열 안 값 출력
//			for(int i=0;i<barr.length;i++) {
//				System.out.print((char)barr[i]+" ");
//			}
			int val = 0;
			while((val =fin.read())!=-1) {
				System.out.print((char)val+" ");
			}
			System.out.println();
			System.out.println("Whie 종료 후 val: "+val);
			
			//한글은 2byte. 깨진다.
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void filesave2() {
		//try with resource문
		//try(객체 생성){}catch(처리할 예외클래스){}
		//자동으로 close()처리.
		
		//FileOutputStream객체 생성
		try(FileOutputStream fout = new FileOutputStream("sample.txt")){
			fout.write(65);
			byte[] b = {66,67};
			fout.write(b);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void fileopen2() {
		//fileopen()과 동일하게 sample.txt에서
		//데이터를 읽어와 출력하기
		//단, try with resource 이용해서 작성
		
		try(FileInputStream fin = new FileInputStream("sample.txt")){
			int size= (int)new File("sample.txt").length();
			byte[] barr = new byte[size];
			fin.read(barr);
			for(int i=0;i<barr.length;i++) {
				System.out.println((char)barr[i]);
			}
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	
	}
}
