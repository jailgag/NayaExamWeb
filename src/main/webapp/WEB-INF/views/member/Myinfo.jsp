<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>평가연습-마이페이지</title>
</head>
<body>
	<h1>기본정보</h1>
		<ul>
		<li>
		
		<lable>아이디</lable>
		<input type="text" name="memberId" value= "${requestScope.member.memberId }" readonly>
		</li>
		
		<li>
		<lable>이름</lable>
		<input type="text" name= "memberName"value= "${requesScope.member.memberName }" readonly>
		</li>
		
		<li>
		<lable>성별</lable>
		<!-- 라디오 버튼에 아무것도 쓰지 않으면 on 이라고 하는 값이 넘어감
		근데 on이 아니라 M, F 가 넘어가야 되므로  -->
		<input type="radio" name="gender" value= "M" <c:if test= "${requestScope.member.gender eq 'M' }"> checked </c:if>disabled >남
		<input type="radio" name="gender" value= "F" <c:if test= "${requestScope.member.gender eq 'F' }"> checked </c:if>disabled >여
		</li>
		
	
		<li>
		<lable>나이</lable>
		<input type="number" value="${requestScope.member.age }"readonly >
		</li>
		
		<li>
		<lable>이메일</lable>
		<input type="text" value="${requestScope.member.email }"readonly >
		</li>
		
		<li>
		<lable>전화번호</lable>
		<input type="text" value="${requestScope.member.phone }"readonly >
		</li>
		
		<li>
		<lable>주소</lable>
		<input type="text" value="${requestScope.member.address }"readonly >
		</li>
		
		
		
		<li>
		<lable>취미</lable>
		<input type="text" value="${requestScope.member.hobby }"readonly >
		</li>
		
		<li>
		<lable>가입일</lable>
		<input type="text" value="${requestScope.member.enrollDate }"readonly >
		</li>
		
		</ul>
		<a href ="/member/modify">수정하기</a> <a href="#">탈퇴하기</a>
	</body>
</html>