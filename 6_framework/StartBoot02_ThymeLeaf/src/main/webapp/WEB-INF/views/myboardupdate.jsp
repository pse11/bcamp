<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update</h1>
	<form action="/myboard/update" method="post">
		<input type="hidden" name="myno" value="${dto.myno }"> 
		<table>
			<tr>
				<th>Myname</th>
				<td>${dto.myname}</td>
			</tr>
			<tr>
				<th>Mytitle</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			</tr>
			<tr>
				<th>Mycontent</th>
				<td><textarea rows="10" cols="40" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>