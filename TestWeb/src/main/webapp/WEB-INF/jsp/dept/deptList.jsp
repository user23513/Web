<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptList.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<a href="DeptInsert">부서등록</a>
	<table border="1">
		<thead>
			<tr>
				<td>부서번호</td>
				<td>부서이름</td>
				<td>매니저번호</td>
				<td>지역번호</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.deptId}</td>
				<td><a href="DeptUpdate?deptId=${vo.deptId}">${vo.deptName}</a></td>
				<td>${vo.deptManagerId}</td>
				<td>${vo.deptLocationId}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>