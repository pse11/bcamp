package com.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//hi라는 요청이 클라이언트로부터 넘어오면 실행되는 서블릿
@WebServlet("/hi")
public class HiController extends HttpServlet{
	//hi라는 요청이 get방식을 넘어올때 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command: "+command);
	}
	
	//hi라는 요청이 post방식을 넘어올때 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("post 방식!");
		String command = request.getParameter("command");
		System.out.println("command: "+command);
	}
}
