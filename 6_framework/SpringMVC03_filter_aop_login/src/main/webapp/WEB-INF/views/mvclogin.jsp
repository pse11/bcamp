<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	const login = ()=>{
		let memberid = $("#memberid").val().trim();
		let memberpw = $("#memberpw").val().trim();
		console.log(memberid+"/"+memberpw);
		let loginVal = {
				"memberid":memberid,
				"memberpw":memberpw
		}
		
		if(memberid==""||memberpw==""){
			alert("ID및 PW를 확인해 주세요")
		}else{
			$.ajax({//ajax : 비동기 통신. (jquery에서 제공)
				//ajax를 이용해 데이터를 json형식으로 서버에 요청. 
				//서버는 전달받은 json데이터를 jackson을 사용해 자바 객체로 변환
				url:"ajaxlogin.do",
				type:"post",
				data:JSON.stringify(loginVal),
				contentType: "application/json",
				dataType: "json",
				success:function(msg){
					console.log(msg);
					if(msg.check==true){ //msg.check : 서버가 준 json데이터에서 check값
						location.href="list.do";
					}else{
						$("#loginChk").html("ID 혹은 PW가 잘못입력되었습니다.")
					}
				},error:function(){
					alert("로그인 실패");
				}
			});
		}
	}
</script>
</head>
<body>
	<h1>login</h1>
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"></td>
		</tr>
		<tr>	
			<th>PW</th>
			<td><input type="text" id="memberpw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="login" onclick="login();"></td>
		</tr>
		<tr>	
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>
</body>
</html>