<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="delete.member"/></title>
</head>
<body>
	<h2><spring:message code="delete.member"/></h2>
	<form:form commandName="deleteCommand"> 
	<p>
		<!-- 
		아이디 : ${authInfo.id }<br>
		 -->
		아이디 : ${authInfo.id }
		<input type="hidden" name="id" value="${authInfo.id }">
	</p>
	<p>
		<!-- 
		이름 : ${authInfo.name }<br>
		 -->
		이름 : ${authInfo.name }
		<input type="hidden" name="name" value="${authInfo.name }">
	</p>
	<p>
		<input type="password" name="password" placeholder="비밀번호를 입력하세요">
	</p>
	<input type="submit" value="<spring:message code="delete.btn"/>">
	<button onclick="window.location='<c:url value="/" />'"><spring:message code="go.main"/></button>
	</form:form>
</body>
</html>