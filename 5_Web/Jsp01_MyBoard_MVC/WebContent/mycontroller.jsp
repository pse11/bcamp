<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.my2.dao.MyBoardDao" %>
<%@ page import="com.my2.dto.MyBoardDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	
	System.out.println("[command: "+command+"]");
	
	MyBoardDao dao = new MyBoardDao();
	if(command.equals("mylist")){
		List<MyBoardDto> res = dao.selectAll();
		request.setAttribute("allList",res);
		pageContext.forward("mylist.jsp");
	}else if(command.equals("myinsertform")){
		response.sendRedirect("myinsert.jsp");
	}else if(command.equals("myinsert")){
		String name= request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		MyBoardDto dto = new MyBoardDto(0,name,title,content,null);
		int res = dao.insert(dto);
		String msg = "";
		String url = "";
		if(res>0){
			msg = "글 작성 성공";
			url = "?command=mylist";
		}else{
			msg="글 작성 실패";
			url ="?command=myinsertform";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("url",url);
		pageContext.forward("result.jsp");
	}else if(command.equals("myupdateform")){
		int no = Integer.parseInt(request.getParameter("no"));
		MyBoardDto dto = dao.selectOne(no);
		
		request.setAttribute("no", no);
		request.setAttribute("dto",dto);
		pageContext.forward("myupdate.jsp");
	}else if(command.equals("myupdate")){
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		MyBoardDto dto = new MyBoardDto(no,null,title,content,null);
		int res = dao.update(dto);
		String msg = "";
		String url ="";
		if(res>0){
			msg ="글 수정 성공";
			url = "?command=mydetail&no="+no;
		}else{
			msg = "글 수정 실패";
			url = "?command=myupdateform&no="+no;
		}
		request.setAttribute("msg",msg);
		request.setAttribute("url",url);
		pageContext.forward("result.jsp");
	}else if(command.equals("mydetail")){
		int no = Integer.parseInt(request.getParameter("no"));
		MyBoardDto dto = dao.selectOne(no);
		request.setAttribute("dto",dto);
		pageContext.forward("mydetail.jsp");
	}else if(command.equals("mydelete")){
		int no = Integer.parseInt(request.getParameter("no"));
		int res = dao.delete(no);
		String msg = "";
		String url = "";
		if(res>0){
			msg = "글 삭제 성공";
			url = "?command=mylist";
		}else{
			msg= "글 삭제 실패";
			url = "?command=mylist";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("url",url);
		pageContext.forward("result.jsp");
	}
%>
</body>
</html>