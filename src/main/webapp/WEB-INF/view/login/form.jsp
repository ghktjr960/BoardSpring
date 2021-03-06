<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<form:form commandName="loginCommand">
		<form:errors />
		<p>
			<label>
				<spring:message code="id" />
				<form:input path="id"/>
				<form:errors path="id"/>
			</label>
		</p>	
		<p>
			<label>
				<spring:message code="password"/>
				<form:password path="password"/>
				<form:errors path="password"/>
			</label>
		</p>	
		<p>
			<label><spring:message code="rememberId" />
			<form:checkbox path="rememberId" />
			</label>
		</p>
		<input type="submit" value="<spring:message code="login.btn"/>">
		<input type="button" value="<spring:message code="go.main"/>" onclick="window.location='<c:url value="/"/>'">
	</form:form>
</body>
</html>