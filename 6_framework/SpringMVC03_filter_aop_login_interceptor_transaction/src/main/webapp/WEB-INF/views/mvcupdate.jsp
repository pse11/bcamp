<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update</h1>
	<form action="update.do" method="post">
		<input type="hidden" name="myno" value="${dto.myno }">
		<table>
			<tr>
				<th>Writer</th>
				<td>${dto.myname }</td>
			</tr>
			<tr>
				<th>Title</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			</tr>
			<tr>
				<th>Content</th>
				<td><textarea rows="10" cols="40" name="mycontent">${dto.mycontent }</textarea>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="완료">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>