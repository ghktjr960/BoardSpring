<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="board.title" /></title>
</head>
<body>
	현재 ${boards.currentPage }
	<br>시작 ${boards.startNum }
	<br>끝 ${boards.endNum }
	<br>카운트${boards.count }
	<br>노출게시글수${boards.pageSize }
	<br>게시글번호${boards.postNum }

	<h2>
		<spring:message code="board.title" />
	</h2>
	<p>
		<button onclick="window.location='<c:url value="/board/write"/>'"><spring:message code="write.btn"/></button>
		<button onclick="window.location='<c:url value="/"/>'"><spring:message code="go.main"/></button>
	</p>
	
	<c:if test="${boards.count == 0}">
		작성된 게시글이 없습니다.
	</c:if>

	<form:form commandName="list">
		<c:if test="${boards.count > 0}">
			<table>
				<tr>
					<th>번 호</th>
					<th>제 목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="postList" items="${boards.postList}">
					<tr>
						<td><c:out value="${boards.postNum}"></c:out> <c:set
								var="number" value="${postNum - 1}"></c:set></td>
						<td><c:if test="${boards.postList.depth > 0}">
								<c:forEach begin="1" end="${boards.postList.depth}">
							&nbsp;&nbsp;
						</c:forEach>
							</c:if> <a
							href="/board/content?num=${boards.postList.num}&pageNum=${boards.currentPage}">
								${boards.postList.subject}</a></td>
						<td>${boards.postList.writer}</td>
						<fmt:formatDate var="formatRegDate"
							value="${boards.postList.regdate}" pattern="yyyy.MM.dd" />
						<td>${formatRegDate}</td>
						<td>${postList.readcount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${boards.count > 0}">
			<c:set var="imsi"
				value="${boards.count % boards.pageSize == 0? 0 : 1}" />
			<c:set var="pageCount"
				value="${boards.count / boards.pageSize + imsi}" />
			<c:set var="pageCount" value="${boards.pageCount}" />

			<c:set var="pageBlock" value="${5}" />

			<c:set var="result" value="${(boards.currentPage - 1) / pageBlock }" />

			<c:set var="startPage" value="${result * pageBlock + 1}" />
			<c:set var="endPage" value="${startPage + pageBlock - 1}" />

			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			<c:if test="${startPage > pageBlock}">
				<a href="/board/list?pageNum=${startPage - pageBlock}">이전</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/board/list?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="/board/list?pageNum=${startPage + pageBlock}">다음</a>
			</c:if>
		</c:if>
	</form:form>
	
</body>
</html>