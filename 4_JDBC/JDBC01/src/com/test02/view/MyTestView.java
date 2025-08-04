package com.test02.view;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.test02.model.MyTestDao;
import com.test02.model.MyTestDto;
public class MyTestView { //MyTestDao가 일 시키는 클래스
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyTestDao dao = new MyTestDao();
		
		int mno = 0;
		String mname = null;
		String nickName = null;
		
		Connection con = getConnection();
		int no = 0;
		do {
			System.out.println("1.전체 출력");
			System.out.println("2.추가");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.종료");
			System.out.println("-----------------");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			switch(no) {
			case 1:
				//전체줄력
				System.out.println("***전체출력***");
				List<MyTestDto> res = dao.getAll(con);
				if(res.size()==0) {
					System.out.println("조회된 데이터가 없습니다.");
				}else {
					for(MyTestDto dto : res) {
						System.out.println(dto);
					}
				} 
				break; 
			case 2:
				//추가
				System.out.println("***추가***");
				System.out.print("추가할 번호: ");
				mno = sc.nextInt();
				System.out.print("추가할 이름: ");
				mname = sc.next();
				System.out.print("추가할 별명: ");
				nickName = sc.next();

				MyTestDto dto = new MyTestDto(mno,mname,nickName);//키보드로 입력한값이 다 저장된다.
				int insertRes =dao.insert(con,dto); //connection넣어줘야 연결할 수 있으니 꼭 넣어야한다.
				if(insertRes>0) {
					System.out.println("입력 성공");
				}else{
					System.out.println("입력 실패");
				}
				break;
			case 3:
				//수정
				System.out.println("***수정***");
				System.out.println("수정할 번호 입력: ");
				mno = sc.nextInt();
				System.out.print("수정할 이름: ");
				mname = sc.next();
				System.out.print("수정할 별명: ");
				nickName = sc.next();
				MyTestDto update = new MyTestDto(mno, mname, nickName);
				int updateRes = dao.update(con, update);
				if(updateRes>0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
				break;
			case 4:
				//삭제
				System.out.println("***삭제***");
				System.out.print("삭제할 번호 입력: ");
				mno = sc.nextInt();
			
				if(dao.delete(con,mno)>0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:
				//종료
				System.out.println("프로그램종료");
				close(con);
				sc.close();
				return;
			}
		}while(no!=5);
	}
}
