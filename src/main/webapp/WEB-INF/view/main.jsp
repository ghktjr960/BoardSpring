<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<c:if test="${empty authInfo }">
	<p>환영합니다</p>
	<p>
		<a href="<c:url value='/register'/>">[회원 가입]</a>
		<a href="<c:url value='/login'/>">[로그인]</a>	
	</p>
	</c:if>
	
	<c:if test="${!empty authInfo }">
	<p>${authInfo.name }님 환영합니다.</p>
	<p>
		<a href="<c:url value='/member/${authInfo.id}' />">[회원정보]</a>
		<a href="<c:url value='/logout' />">[로그아웃]</a>
	</p>
	</c:if>
	<button onclick="window.location='<c:url value='/board/list'/>'"><spring:message code="board.btn"/></button>
	
	
</body>
</html>