package com.mlp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mlp.dao.MemberDao;
import com.mlp.dto.BoardDto;
import com.mlp.dto.MemberDto;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");
		System.out.println("command: "+command);
		HttpSession session = request.getSession();

		MemberDao dao = new MemberDao();
		
		if(command.equals("login")) {
			String id= request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDto res = dao.login(id);
			if(res!=null) {
				if(res.getPw().equals(pw)) {
					System.out.println("로그인 되었습니다.");
					session.setAttribute("dto", res);
					session.setMaxInactiveInterval(60*60);
					response.sendRedirect("board?command=showfeeds");
				}else {
					System.out.println("비밀번호를 확인해 주세요.");
					response.sendRedirect("login.jsp");
				}
			}else {
				System.out.println("아이디와 비밀번호를 확인해 주세요.");
				response.sendRedirect("login.jsp");
			}
		}else if(command.equals("updateprofile")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String info = request.getParameter("infomsg");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			MemberDto dto = new MemberDto();
			dto.setNo(no);
			dto.setInfo(info);
			dto.setEmail(email);
			dto.setPhone(phone);
			
			int res = dao.updateProfile(dto);
			if(res>0) {
				System.out.println("프로필 수정 성공");
				MemberDto mem = dao.selectMember(no);
				response.sendRedirect("member?command=login&id="+mem.getId()+"&pw="+mem.getPw());
			}else {
				System.out.println("프로필 수정 실패");
				response.sendRedirect("login.jsp");
			}
		}else if(command.equals("logout")) {
			session = request.getSession(false);
			if(session!=null) {
				session.invalidate();
			}
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
