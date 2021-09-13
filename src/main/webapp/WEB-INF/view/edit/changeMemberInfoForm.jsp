<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="change.memberInfo.title"/></title>
</head>
<body>
	<h2><spring:message code="change.memberInfo.title"/></h2>

	<form:form modelAttribute="infoCommand" commandName="infoCommand">
	<p>
		<label>
		<b><spring:message code="id"/></b><br>
		<input type="text" value="${memberInfo.id}" name="id" readonly="readonly">
		<form:errors path="id"/>
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="name"/></b><br>
		<input type="text" value="${memberInfo.name}" name="name">
		<form:errors path="name"/>
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="email"/></b><br>
		<input type="text" value="${memberInfo.email}" name="email">
		<form:errors path="email"/>
		</label>
	</p>
	<p>
		<label>
		<b><spring:message code="birthday"/></b><br>
		<input type="date" name="birthday">
		<form:errors path="birthday" />
		</label>
	<p>
	<p>
		<b><spring:message code="gender"/></b><br>
		<c:choose>
			<c:when test="${memberInfo.gender eq 'man' }">
				남자
			</c:when>
			<c:when test="${memberInfo.gender eq 'woman' }">
				여자
			</c:when>
		</c:choose>
	</p>
	<p>
		<b><spring:message code="regdate"/></b><br>
		<fmt:formatDate value="${memberInfo.regdate}" pattern="yyyy-MM-dd"/>
	</p>
	<input type="submit" value=<spring:message code="change.btn"/>> 
	<input type="reset" value="<spring:message code="reset.btn"/>">
	<input type="button" value="<spring:message code="go.main"/>" onclick="window.location='<c:url value='/'/>'" >
</form:form>
</body>
</html>