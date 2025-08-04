<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	async function idcheck(){
		let id = document.getElementsByName("id")[0];
		if(id.value.trim()==""||id.value==null){
			alert("아이디를 입력해주세요");
		}else{
			try{
				const response = await fetch("member?command=idcheck&id="+id.value.trim());
				const result = await response.json();
				if(result.msg==="Y"){
					alert("사용중인 아이디입니다.");
					id.value="";
				}else if(result.msg==="N"){
					alert("사용가능한 아이디입니다.");
				}
			}catch(error){
				alert("실패");
			}
		}
	}
</script>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="member" method="post">
		<input type="hidden" name="command" value="regist">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" required="required">
					<input type="button" value="중복체크" onclick="idcheck()">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pw" required="required"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>	
				<th>전화번호</th>
				<td><input type="text" name="phone" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">	
					<input type="submit" value="가입하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>