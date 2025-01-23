<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>평가연습-회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/member/register" method="post">
		<ul>
		<li>
		<lable>아이디</lable>
		<input type="text" name="memberId">
		</li>
		
		<li>
		<lable>비밀번호</lable>
		<input type="password" name="memberPwd">
		</li>
		
		<li>
		<lable>이름</lable>
		<input type="text" name= "memberName">
		</li>
		
		<li>
		<lable>성별</lable>
		<!-- 라디오 버튼에 아무것도 쓰지 않으면 on 이라고 하는 값이 넘어감
		근데 on이 아니라 M, F 가 넘어가야 되므로  -->
		<input type="radio" name="gender" value= "M">남
		<input type="radio" name="gender" value="F">여
		</li>
		
		<li>
		<lable>나이</lable>
		<input type="number" name="age">
		</li>
		
		</ul>
		<input type="submit" value="가입하기">
	</form>
</body>
</html>