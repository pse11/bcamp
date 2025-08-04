package com.collection.silsub1.model.dao;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.collection.silsub1.model.vo.Board;

//dao(Data Access Object)
public class BoardDao {
	private ArrayList<Board> list = new ArrayList<Board>();
	
	public BoardDao() {
		//객체 생성시 board.txt로부터 저장된 데이터 입력받기
		//그렇게 input받은 데이터를 list에 추가
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("board.txt"));){
			while(true) {
				list.add((Board)(oi.readObject()));
			}
			//종료되는 조건이 없는 while이기에
			//End of File까지 반복.
			
		}catch(EOFException e) {
			System.out.println("실행 준비 완료");
			return;
		}
		catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch (IOException e){
		}catch (ClassNotFoundException e) {
		}
	}
	
	//게시글 저장
	public void write(Board board) {
		list.add(board);
	}
	//list에 저장된 게시글 중 마지막 게시글의 번호를 리턴한다.
	public int getLastNo() {
		return list.get(list.size()-1).getBoardNo();
		//첫번째 경우 list.size가 0이 되면 list의 -1번째 인덱스의 값을 가져와야하는데 불가능하므로 list.size()-1해줘야한다.
	}
	
	//게시글 전체 확인용
	public ArrayList<Board> displayAll() { //제너릭 해주면 편리하다. 나중에 형변환 해줄 필요가 없어서.
		return list;
	}
	
	//파일에 list 저장
	public void saveList() {
		//ObjectOutputStream		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("board.txt"))){
			//출력, write board 객체 하나씩 넣는다.
			for(int i=0;i<list.size();i++) {
				//board 객체 하나씩 board.txt에 출력
				os.writeObject(list.get(i));
			}	
			System.out.println("board.txt에 저장 완료");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//게시글 한개 보기
	public Board displayOne(int no) {
		//매개변수로 넘어온 게시글 번호와
		//일치 하는 게시글 찾기
		//return list.get(no-1);
		
		Board board = null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBoardNo()==no) {
				board = list.get(i);
				break;
			}
		}
		return board;
	}
	
	//제목 수정
	public void updateTitle(int no, String title) {
		//매개변수로 넘어오는
		//no와 일치하는 게시글의 제목을 title로 변경
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBoardNo()==no) {
				list.get(i).setBoardTitle(title);
				break;
			}
		}
	}
	
	public void updateContent(int no, String content) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBoardNo()==no) {
				list.get(i).setBoardContent(content);
				break;
			}
		}
	}
	
	public void delete(int no) {
//		list.remove(no-1);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBoardNo()==no) {
				list.remove(i);
			}
		}
	}
	
	public ArrayList<Board> search(String title){
		//검색 결과 여러개일수도있으니 리스트로 리턴
		ArrayList<Board> res = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBoardTitle().contains(title)) {//제목 포함인지
				res.add(list.get(i));
			}
		}
		return res; //만약 제목 일치하는게 없으면 리스트가 있지만 size가 0일뿐이다.
	}
}
