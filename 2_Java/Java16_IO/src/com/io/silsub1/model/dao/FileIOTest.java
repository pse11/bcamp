package com.io.silsub1.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest {
	public void fileSave() {
//		[실습문제 1]
//				 - 패키지 : com.io.silsub1.model.dao
//				 - 클래스 : FileIOTest 
//					>> 메소드 추가함
//					+ fileSave() : void
//					=> 키보드로 사용할 파일명을 입력받음
//						BufferedReader의 readLine() 사용함
//					=> 파일출력용 스트림 객체 생성함
//						FileWriter 사용함
//					=> 화면에 "파일에 저장할 내용을 입력하시오." 출력
//						입력값을 읽어들여서 바로 파일에 기록 저장처리
//						반복실행함
//					=> "exit"가 입력되면, 반복은 종료하고
//						화면에 "파일에 성공적으로 저장되었습니다." 출력하고
//					=> 파일출력 스트림을 닫음.

		//new 보조스트림(new 보조스트림(기반스트림));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("파일명 입력:");
		FileWriter fw=null;
		try {
			String fileName = br.readLine();
			
			//new 기반스트림("외부자원");
			fw = new FileWriter(fileName+".txt",true);
			while(true) {
				System.out.println("파일에 저장할 내용을 입력하시오.");
				String fileContent = br.readLine();
				if(fileContent.equals("exit")){
					break;
				}
				fw.write("\n"+fileContent);
				//fw.write(fileContent.toCharArray());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("파일에 성공적으로 저장되었습니다.");
				fw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void fileRead() {
//		[실습문제 2]
//				 - 위에서 작성한 FileIOTest 클래스에 메소드 추가함
//				 	>> 메소드
//					+ fileRead() : void
//					=> 키보드로 읽을 대상파일명을 입력받음
//					=> 파일 읽기용 스트림 객체 생성함 : FileReader 사용  -> Read이용
//					=> 파일 안의 내용을 읽어서, StringBuilder 에 보관함
//					=> 다 읽은 다음, StringBuilder 에 보관된 값을 
//					   String으로 바꾸어 화면에 출력함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("읽어올 파일명 입력: ");
		FileReader fr = null;
		try {
			String fileName = br.readLine();
			fr = new FileReader(fileName+".txt");
			StringBuilder stb = new StringBuilder();
			while(fr.read()!=-1) {
				stb.append((char)fr.read());
			}
			String str = stb.toString();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
