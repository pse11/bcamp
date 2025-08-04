package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.my.dao.MemberDao;
import com.my.dto.MemberDto;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		String command = request.getParameter("command");
		System.out.println("command: "+command);
		
		MemberDao dao = new MemberDao();
		if(command.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			//id로 selectone해온 객체의 pw값과 파라미터 pw값 비교해서 일치하면 로그인
			MemberDto res = dao.selectOne(id);
			if(res==null) {
				System.out.println("아이디를 다시 확인해주세요");
				response.sendRedirect("index.jsp");
			}else {
				if(res.getEnabled().equals("Y")) {
					if(res.getPw().equals(pw)) {
						System.out.println("로그인되었습니다.");
						session.setAttribute("memberdto", res);
						session.setMaxInactiveInterval(60*60);
						response.sendRedirect("board?command=login");
					}else {
						System.out.println("비밀번호를 다시 확인해주세요");
						response.sendRedirect("index.jsp");
					}
				}else {
					System.out.println("탈퇴한 아이디입니다.");
					response.sendRedirect("index.jsp");
				}
			}
		}else if(command.equals("registform")) {
			response.sendRedirect("regist.jsp");
		}else if(command.equals("regist")) {
			String id= request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			
			MemberDto dto = new MemberDto(0,id,pw,name,phone,null);
			int res = dao.insert(dto);
			if(res>0) {
				System.out.println("회원가입 성공");
				response.sendRedirect("index.jsp");
			}else {
				System.out.println("회원가입 실패");
				response.sendRedirect("index.jsp");
			}
		}else if(command.equals("mypage")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			MemberDto dto = dao.selectOne(no);
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("mypage.jsp");
			dis.forward(request, response);
		}else if(command.equals("updateform")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			MemberDto dto = dao.selectOne(no);
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("updatemember.jsp");
			dis.forward(request, response);
		}else if(command.equals("update")) {
			String pw = request.getParameter("pw");
			String phone = request.getParameter("phone");
			int no = Integer.parseInt(request.getParameter("no"));
			
			MemberDto dto = new MemberDto();
			dto.setNo(no);
			dto.setPhone(phone);
			dto.setPw(pw);
			int res = dao.update(dto);
			if(res>0) {
				System.out.println("회원정보 수정 성공");
				response.sendRedirect("member?command=mypage&no="+no);
			}else {
				System.out.println("회원정보 수정 실패");
				response.sendRedirect("member?command=updateform&no="+no);
			}
		}else if(command.equals("unenable")) {
			int no = Integer.parseInt(request.getParameter("no"));
			int res = dao.unenable(no);
			if(res>0) {
				System.out.println("탈퇴완료");
				response.sendRedirect("index.jsp");
			}else {
				System.out.println("탈퇴실패");
				response.sendRedirect("member?command=mypage&no="+no);
			}
		}else if(command.equals("idcheck")) {
			String id= request.getParameter("id");
			MemberDto dto = dao.selectOne(id);
		
			JSONObject obj = new JSONObject();
			if(dto!=null) {//이미 존재하는 아이디
				obj.put("msg", "Y");
			}else{
				obj.put("msg", "N");
			}
			PrintWriter out = response.getWriter();
			out.print(obj.toJSONString());
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
