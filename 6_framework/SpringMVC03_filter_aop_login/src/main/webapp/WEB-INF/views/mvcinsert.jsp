<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert</h1>
	<form action="insert.do" method="post">
		<table>
			<tr>
				<th>Writer</th>
				<td><input type="text" name="myname"></td>
			</tr>	
			<tr>
				<th>Title</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>Context</th>
				<td><textarea rows="10" cols="40" name="mycontent"></textarea></td>
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