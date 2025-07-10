package com.mlp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlp.dao.BoardDao;
import com.mlp.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");
		
		BoardDao dao = new BoardDao();
		if(command.equals("showfeeds")) {
			List<BoardDto> list = dao.selectAll();
			request.setAttribute("list", list);
			RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("createfeed")) {
			String title = request.getParameter("title");
			String keyword = request.getParameter("keyword");
			String content = request.getParameter("content");
			String release = request.getParameter("release");
			String writer = request.getParameter("writer");
			String id= request.getParameter("id");
			
			BoardDto dto = new BoardDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setKeyword(keyword);
			dto.setRelease(release);
			dto.setId(id);
			int res = dao.insertFeed(dto);
			
//			JSONObject obj = new JSONObject();
//			if(res>0) {
//				System.out.println("피드 작성 성공");
//				obj.put("writer", writer);
//				obj.put("title", title);
//				obj.put("content", content);
//				obj.put("keyword",keyword);
//				obj.put("release", release);
//				
//			}else {
//				System.out.println("피드 작성 실패");
//			}
//			response.getWriter().write(obj.toJSONString());
			if(res>0) {
				System.out.println("피드 작성 성공");
				response.sendRedirect("board?command=showfeeds");
			}else {
				System.out.println("피드 작성 실패");
				response.sendRedirect("board?command=showfeeds");
			}
		}else if(command.equals("bookmark")) {
			response.sendRedirect("bookmark.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
