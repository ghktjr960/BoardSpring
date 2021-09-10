<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	
	지금 회원가입, 로그인, 로그아웃 기능만 만들어둠
	JSP페이지, 테이블 다 작성해야됨


	<c:if test="${empty authInfo }">
	<p>환영합니다</p>
	<p>
		<a href="<c:url value='/register/step1'/>">[회원 가입]</a>
		<a href="<c:url value='/login'/>">[로그인]</a>	
	</p>
	</c:if>
	
	<c:if test="${!empty authInfo }">
	<p>${authInfo.name }님 환영합니다.</p>
	<p>
		<a href="<c:url value='/edit/changePassword' />">[비밀번호 변경]</a>
		<a href="<c:url value='/logout' />">[로그아웃]</a>
	</p>
	</c:if>
	<a href="<c:url value='/member/list' />">[회원목록 검색]</a>
	
</body>
</html>