<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="change.pwd.title" /></title>
</head>
<body>
	<form:form commandName="pwdCommand">
	<p>
		<label>
			<spring:message code="currentPassword"/>
			<form:password path="currentPwd"/>
			<form:errors path="currentPwd"/>
		</label>	
	</p>
	<p>
		<label>
			<spring:message code="newPassword"/>
			<form:password path="newPwd"/>
			<form:errors path="newPwd"/>
		</label>	
	</p>
	<input type="submit" value="<spring:message code="change.btn"/>">
	<button onclick='<c:url value="/" />'><spring:message code="go.main"/></button>
	</form:form>
</body>
</html>