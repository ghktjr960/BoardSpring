<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
	<p>아이디 : ${memberInfo.id}</p>
	<p>이름 : ${memberInfo.name}</p>
	<p>이메일 : ${memberInfo.email}</p>
	<p>생년월일 : <fmt:formatDate value="${memberInfo.birthday}" pattern="yyyy-MM-dd"/></p>
	<p>성별 : 
	 <c:choose>
	 	<c:when test="${memberInfo.gender eq 'man' }">
	 		남자
	 	</c:when>
	 	<c:when test="${memberInfo.gender eq 'woman' }">
	 		여자
	 	</c:when>
	 </c:choose>
	</p>
	<p>가입일 : <fmt:formatDate value="${memberInfo.regdate}" pattern="yyyy-MM-dd"/></p>
	<button onclick="window.location='<c:url value="/"/>'"><spring:message code="go.main"/></button>
	<button onclick="window.location='<c:url value="/edit/changePassword"/>'"><spring:message code="change.pwd.title"/></button>
	<button onclick="window.location='<c:url value="/edit/changeMemberInfo"/>'"><spring:message code="change.memberInfo.title"/></button>
	
	
	
</body>
</html>