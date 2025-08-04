package com.part03_wrapperStream.test3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObject {
	public static void main(String[] args) {
		//new TestObject().fileSave();
		new TestObject().fileOpen();
	}
	public void fileSave() {
		Member mar[] = {
				new Member("user01","pass01","박상은","ppp@multi.com",20,'남',1200.4),
				new Member("user02","pass02","김상은","kkk@multi.com",25,'남',1222.4),
				new Member("user03","pass02","이상은","lll@multi.com",22,'여',1219.4)
		};
		
		//객체 출력
		//ObjectOutputStream 클래스 사용 , 보조 스트림
		ObjectOutputStream objOut = null;
		
		try {
			objOut = new ObjectOutputStream(new FileOutputStream("member.txt"));//File: 기반스트림
			for(int i=0;i<mar.length;i++) {
				objOut.writeObject(mar[i]);
			}
			
			objOut.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	public void fileOpen() {//불러오기
		Member[] mar = new Member[3];
		
		//스트림 객체 생성 (try with resource로 생성했기에 자동으로 close처리된다.)
		try (ObjectInputStream objIn  = new ObjectInputStream(new FileInputStream("member.txt"))){
			//입력
			mar[0] = (Member)objIn.readObject();
			mar[1] = (Member)objIn.readObject();
			mar[2] = (Member)objIn.readObject();
			
			//입력받은 객체를 콘솔에 출력
			for(Member m : mar) {
				System.out.println("읽어온 객체:"+m);
				System.out.println(m.addr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
}
