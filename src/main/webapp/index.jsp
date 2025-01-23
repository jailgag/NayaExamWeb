<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>평가연습 -메인</title>
</head>
<body>
	<h1>평가 연습에 오신것을 환영합니다</h1>
	<c:if test="${sessionScope.member.memberId != null }">
		${sessionScope.member.memberName } 님 환영합니다~
		<a href="/member/signout">로그아웃</a><br>
		<a href="/member/myinfo">마이페이지</a>
	</c:if>
	<c:if test="${sessionScope.member.memberId eq null }">
	<fieldset>
	<legend>로그인</legend>
	<form action="/member/signin" method="post">
	<ul>
	<li>
	<label>아이디</label>
	<input type="text" name="memberId">
	</li>
	
	<li>
	<label>비밀번호</label>
	<input type="password" name="memberPwd">
	</li>
	</ul>
		<input type="submit" value="로그인">        <!-- 로그인  -->
	</form>
	<a href="/member/register">회원가입</a>  <!-- get방식!!! -->
	</fieldset>
	</c:if>
</body>
</html>