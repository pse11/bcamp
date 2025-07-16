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
		}else if(command.equals("boardorder")) {
			String orderby = request.getParameter("orderby");
			List<BoardDto> res = dao.order(orderby);
			request.setAttribute("list", res);//request 객체에 list 이름으로 res를 저장. 
			//request에 저장된 값은 forward된 JSP에서 꺼내 쓸 수 있음.
			RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
			//JSP파일로 포워딩 준비. RequestDispatcher는 main.jsp로 넘어가게 해줄 객체.
			dispatch.forward(request, response);
			//forward : 서버 내부에서 페이지를 이동.
			//클라이언트는 URL이 안바뀌고, 서버안에서 main.jsp를 실행해서 HTML을 만들어 다시 브라우저로 보냄.
			//즉, 서블릿->jsp로 넘어가서 뷰를 출력하는 동작.
		}else if(command.equals("updateform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			BoardDto res = dao.selectBoard(boardno);
			//String loginid= request.getParameter("loginid");
			//if(loginid.equals(res.getId())) {
				request.setAttribute("updatedto", res);
				RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
				dispatch.forward(request,response);
			//}else {
			//	request.setAttribute("check",true);
			//	System.out.println("작성자 본인만 수정가능");
//				RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
//				dispatch.forward(request,response);
//			}
			
		}else if(command.equals("updatefeed")) {
			String title = request.getParameter("title");
			String keyword = request.getParameter("keyword");
			String content = request.getParameter("content");
			String release = request.getParameter("release");
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDto dto = new BoardDto();
			dto.setNo(no);
			dto.setTitle(title);
			dto.setKeyword(keyword);
			dto.setContent(content);
			dto.setRelease(release);
			int res = dao.update(dto);
			if(res>0) {
				response.sendRedirect("board?command=showfeeds");
			}else {
				response.sendRedirect("board?command=showfeeds");
			}
		}else if(command.equals("search")) {
			String feedsearch = request.getParameter("feedsearch");
			List<BoardDto> dto = dao.search(feedsearch);
			request.setAttribute("list", dto);
			RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
			dispatch.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
