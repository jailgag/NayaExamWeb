<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>평가연습 - 정보수정</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<fieldset>
	<legend>회원정보 수정</legend>
	<form action= "/member/modify" method="post">
	<input type="hidden" name="memberId" value="${requestScope.member.memberId }">
	<li>
		<lable>이메일</lable>
		<input type="text" name="email" value="${requestScope.member.email }" >
		</li>
		
		<li>
		<lable>전화번호</lable>
		<input type="text" name="phone" value="${requestScope.member.phone }" >
		</li>
		
		<li>
		<lable>주소</lable>
		<input type="text" name="address" value="${requestScope.member.address }" >
		</li>
		
		
		
		<li>
		<lable>취미</lable>
		<input type="text" name="hobby" value="${requestScope.member.hobby }" >
		</li>
		
		<input type="submit" value="수정하기">
	</form>
	</fieldset>
</body>
</html>