package com.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.dao.BoardDao;
import com.my.dto.BoardDto;
import com.my.dto.MemberDto;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		String command = request.getParameter("command");
		
		BoardDao dao = new BoardDao();
		if(command.equals("login")) {
			MemberDto memberdto = (MemberDto)session.getAttribute("memberdto");
			List<BoardDto> list = dao.selectAll();
			request.setAttribute("memberdto", memberdto);
			request.setAttribute("list", list);
			RequestDispatcher dis = request.getRequestDispatcher("boardlist.jsp");
			dis.forward(request, response);
		}else if(command.equals("logout")) {
			System.out.println("로그아웃되었습니다");
			session.invalidate();
			response.sendRedirect("index.jsp");
			
		}else if(command.equals("mypage")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			response.sendRedirect("member?command=mypage&no="+no);
		}else if(command.equals("boarddetail")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			BoardDto dto = dao.selectOne(no);
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boarddetail.jsp");
			dis.forward(request, response);
		}else if(command.equals("updateform")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			BoardDto dto = dao.selectOne(no);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("updateboard.jsp");
			dis.forward(request, response);
		}else if(command.equals("update")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			BoardDto dto = new BoardDto();
			dto.setNo(no);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = dao.update(dto);
			if(res>0) {
				System.out.println("글 수정 성공");
				response.sendRedirect("board?command=login");
			}else {
				System.out.println("글 수정 실패");
				response.sendRedirect("board?command=updateform");
			}
		}else if(command.equals("delete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			int res = dao.delete(no);
			if(res>0) {
				System.out.println("글 삭제 성공");
				response.sendRedirect("board?command=login");
			}else {
				System.out.println("글 삭제 실패");
				response.sendRedirect("board?command=boarddetail&no="+no);
			}
		}else if(command.equals("boardwriteform")) {
			MemberDto dto = (MemberDto)session.getAttribute("memberdto");
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boardwrite.jsp");
			dis.forward(request, response);
		}else if(command.equals("boardwrite")) {
			String title = request.getParameter("title");
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			
			BoardDto dto = new BoardDto();
			dto.setTitle(title);
			dto.setName(name);
			dto.setContent(content);
			
			int res = dao.insert(dto);
			if(res>0) {
				System.out.println("글 작성 성공");
				response.sendRedirect("board?command=login");
			}else {
				System.out.println("글 작성 실패");
				response.sendRedirect("boardwriteform");
			}
		}else if(command.equals("muldel")) {
			String[] chks = request.getParameterValues("chk"); 
			
			int res = dao.muldel(chks);
			if(res==chks.length) {
				System.out.println("글 삭제 성공");
				response.sendRedirect("board?command=login");
			}else {
				System.out.println("글 삭제 실패");
				response.sendRedirect("board?command=login");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
