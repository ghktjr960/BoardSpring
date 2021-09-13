<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
<h2><spring:message code="member.info"/></h2>
<form:form action="register" commandName="formData">
	<p>
		<label>
		<b><spring:message code="id"/></b><br>
		<form:input path="id" />
		<form:errors path="id" />
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="password"/></b><br>
		<form:password path="password"/>
		<form:errors path="password" />
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="password.confirm"/></b><br>
		<form:password path="confirmPassword"/>
		<form:errors path="confirmPassword"/>
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="name"/></b><br>
		<form:input path="name"/>
		<form:errors path="name" />
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="birthday"/></b><br>
		<input type="date" name="birthday">
		<form:errors path="birthday" />
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="gender"/></b><br>
		<form:radiobutton path="gender" value="man"/>남자
		<form:radiobutton path="gender" value="woman"/>여자
		<form:errors path="gender" />
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="email"/></b><br>
		<form:input path="email"/>
		<form:errors path="email" />
		</label>
	</p>
	<input type="submit" value="<spring:message code="register.btn"/>">
	<input type="reset" value="<spring:message code="reset.btn"/>">
	<input type="button" value="<spring:message code="go.main"/>" onclick="window.location='<c:url value='/'/>'" >
</form:form>
</body>
</html>