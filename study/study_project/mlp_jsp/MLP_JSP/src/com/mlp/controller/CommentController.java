package com.mlp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlp.dao.CommentDao;
import com.mlp.dto.CommentDto;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		CommentDao dao = new CommentDao();
		String command = request.getParameter("command");
		if(command.equals("insert")) {
			String id= request.getParameter("id");
			String content = request.getParameter("content");
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String name= request.getParameter("name");
			CommentDto dto = new CommentDto();
			dto.setId(id);
			dto.setBoardno(boardno);
			dto.setContent(content);
			dto.setName(name);
			int res = dao.insert(dto);
			if(res>0) {
				response.sendRedirect("board?command=showfeeds");
			}else {
				response.sendRedirect("board?command=showfeeds");
			}
		}else if(command.equals("updateform")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String content = request.getParameter("content");
			request.setAttribute("no", no);
			request.setAttribute("content", content);
			RequestDispatcher dispatch = request.getRequestDispatcher("commentupdate.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("update")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String content = request.getParameter("content");
			CommentDto dto = new CommentDto();
			dto.setNo(no);
			dto.setContent(content);
			int res = dao.update(dto);
			if(res>0) {
				response.sendRedirect("board?command=showfeeds");
			}else {
				response.sendRedirect("board?command=showfeeds");
			}
		}else if(command.equals("delete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			int res = dao.delete(no);
			if(res>0) {
				response.sendRedirect("board?command=showfeeds");
			}else {
				response.sendRedirect("board?command=showfeeds");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
