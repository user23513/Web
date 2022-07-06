<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
</head>
<body>
	<div>
		<table border>
			<thead>
				<tr>
					<th>id</th>
					<th>title</th>
					<th>content</th>
					<th>writer</th>
					<th>rdt</th>
					<th>hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.id}</td>
						<td><a href="boardUpdate?id=${vo.id}">${vo.title}</a></td>
						<td>${vo.content}</td>
						<td>${vo.writer}</td>
						<td>${vo.rdt}</td>
						<td>${vo.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" onclick="boardInsert()">글쓰기</button>
	</div>
	<script>
		function boardInsert() {
			location.href="boardInsert";
		}
	</script>

</body>
</html>