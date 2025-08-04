package com.mlp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlp.dao.MemberDao;
import com.mlp.dao.ReplyDao;
import com.mlp.dto.MemberDto;
import com.mlp.dto.ReplyDto;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");
		
		ReplyDao dao = new ReplyDao();
		MemberDao mdao = new MemberDao();
		if(command.equals("reply")) {
			String reply = request.getParameter("replys");
			int commentno = Integer.parseInt(request.getParameter("commentno"));
			int writerno = Integer.parseInt(request.getParameter("writerno"));
			
			MemberDto mdto = mdao.selectMember(writerno);
			
			ReplyDto dto = new ReplyDto();
			dto.setId(mdto.getId());
			dto.setName(mdto.getName());
			dto.setReply(reply);
			dto.setCno(commentno);
			int res = dao.insert(dto);
			if(res>0) {
				response.sendRedirect("main.jsp");
			}else {
				response.sendRedirect("main.jsp");				
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
